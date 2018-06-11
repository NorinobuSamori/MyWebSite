package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoOrderHistory;
import dao.DaoOrderHistoryKeys;
import model.BeansEventDetailInfo;
import model.BeansUserInfo;

/**
 * Servlet implementation class SitePlaceUsersOrder
 */
@WebServlet("/SiteInPlaceUsersOrder")
public class SiteInPlaceUsersOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteInPlaceUsersOrder() {
        super();
        // TODO Auto-generated constructor stub
    }


////このServletで、SiteEventHistory.javaにジャンプさせる


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();

		 ////モデルはBuyResult.java

		 try {
			 	////ログインセッション確認
				BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
				if (beansUserInfoAccount == null) {
					// Sessionにリターンページ情報を書き込む
					session.setAttribute("returnStrUrl", "SiteInPlaceUsersOrder");
					// Login画面にリダイレクト
					response.sendRedirect("SiteLogin");
					return;
				}
				//ログインセッションがあった場合
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				//合計金額をgetしてsetする
				beansEventDetailInfo = (BeansEventDetailInfo) session.getAttribute("beansEventDetailInfo");
				beansEventDetailInfo.setTotal_fees(beansEventDetailInfo.getTotal_fees());
				//user_idをgetしてsetする
				beansEventDetailInfo.setUser_id(beansUserInfoAccount.getId());



				// セッションからカート情報を取得する
				ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("beansEventDetailInfoList");

				// 購入情報を登録
				int order_id = DaoOrderHistory.insertOrder(beansEventDetailInfo);

				// 購入詳細情報を購入情報IDに紐づけして登録
				for (BeansEventDetailInfo beansEventDetailInfoListOne : beansEventDetailInfoList) {
					BeansEventDetailInfo beansEventDetailInfo22 = new BeansEventDetailInfo();
					beansEventDetailInfo22.setOrder_id_key(order_id);
					beansEventDetailInfo22.setEvent_id_key(beansEventDetailInfoListOne.getId());
					DaoOrderHistoryKeys.insertOrderHistoryKeysByBeans(beansEventDetailInfo22);
				}

				BeansEventDetailInfo orderHistory = DaoOrderHistory.getBeansEventDetailInfoByOrder_id(order_id);
				session.setAttribute("orderHistory", orderHistory);

				// 購入アイテム情報 //ここでカート情報由来ではないorder情報から引き出してセットする
				ArrayList<BeansEventDetailInfo> orderHistoryEventList = DaoOrderHistoryKeys.getBeansEventDetailInfoListByOrder_Id(order_id);
				session.setAttribute("orderHistoryEventList", orderHistoryEventList);

				//カートセッションをremoveする
				session.removeAttribute("beansEventDetailInfoList");
				session.setAttribute("orderedActionMessage", "決済が完了しました");
				response.sendRedirect("SiteEventHistory");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("エラーメッセージ on SiteInPlaceUsersOrder.java");
				request.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}

	}

}
