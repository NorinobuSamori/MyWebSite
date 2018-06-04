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
 * Servlet implementation class OneOrderedHistory
 */
@WebServlet("/SiteOneOrderedHistory")
public class SiteOneOrderedHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteOneOrderedHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();

		 try {
			BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "SiteInPlaceUsersOrder");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}

			int order_id =  Integer.parseInt(request.getParameter("order_id"));

			BeansEventDetailInfo orderHistory = DaoOrderHistory.getBeansEventDetailInfoByOrder_id(order_id);
			session.setAttribute("orderHistory", orderHistory);

			// 購入アイテム情報 //ここでカート情報由来ではないorder情報から引き出してセットする
			ArrayList<BeansEventDetailInfo> orderHistoryEventList = DaoOrderHistoryKeys.getBeansEventDetailInfoListByOrder_Id(order_id);
			session.setAttribute("orderHistoryEventList", orderHistoryEventList);

			response.sendRedirect("SiteEventHistory");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("エラーメッセージ on SiteOneOrderedHistory.java");
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}



}
