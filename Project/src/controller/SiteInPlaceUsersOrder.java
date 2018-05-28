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
import templates.Addresses;

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


////このServletで、SiteEventHistoryにジャンプさせる


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
				//ログインセッションがあった場合、user_idをgetしてsetする
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				beansEventDetailInfo.setUser_id(beansUserInfoAccount.getId());

				// セッションからカート情報を取得する
				ArrayList<BeansEventDetailInfo> inCartBeansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("inCartBeansEventDetailInfoList");


				// 購入情報を登録
				int order_id = DaoOrderHistory.insertOrder(beansEventDetailInfo);

				// 購入詳細情報を購入情報IDに紐づけして登録
				for (BeansEventDetailInfo inCartBeansEventDetailInfoListOne : inCartBeansEventDetailInfoList) {
					BeansEventDetailInfo beansEventDetailInfo22 = new BeansEventDetailInfo();
					beansEventDetailInfo22.setOrder_id_key(order_id);
					beansEventDetailInfo22.setEvent_id_key(inCartBeansEventDetailInfoListOne.getId());
					DaoOrderHistoryKeys.insertOrderHistoryKeysByBeans(beansEventDetailInfo22);
				}


				BeansEventDetailInfo orderHistory = DaoOrderHistory.getBeansEventDetailInfoByOrder_id(order_id);
				session.setAttribute("orderHistory", orderHistory);

				// 購入アイテム情報 //ここでカート情報由来ではないOrder情報から引き出してセットする
				ArrayList<BeansEventDetailInfo> orderHistoryEvents = DaoOrderHistoryKeys.getBeansEventDetailInfoListByOrder_Id(order_id);
				session.setAttribute("orderHistoryEvents", orderHistoryEvents);

				//カートセッションをremoveする
				session.removeAttribute("inCartBeansEventDetailInfoList");
				request.getRequestDispatcher(Addresses.SITE_EVENT_HISTORY).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("エラーメッセージ on SiteInPlaceUsersOrder.java");
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}

	}

}
