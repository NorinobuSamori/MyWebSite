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
import model.BeansEventDetailInfo;
import model.BeansUserInfo;
import templates.Addresses;

/**
 * Servlet implementation class SiteEventHistory
 */



@WebServlet("/SiteEventHistory")
public class SiteEventHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteEventHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		try {
			////ログインセッション確認
			BeansUserInfo beansUserInfoAccount = new BeansUserInfo();
			beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "SiteEventHistory");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}
			//ログインセッションがあった場合、user_idをgetしてsetする
			BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
			beansEventDetailInfo.setUser_id(beansUserInfoAccount.getId());


			//モデルはUserData.java
			DaoOrderHistory daoOrderHistory = new DaoOrderHistory();
			ArrayList<BeansEventDetailInfo> orderWhereUserBeansList = daoOrderHistory.getBeansEventDetailInfoWhereUser_Id(beansEventDetailInfo.getUser_id());


			session.setAttribute("orderWhereUserBeansList", orderWhereUserBeansList);


			request.getRequestDispatcher(Addresses.SITE_EVENT_HISTORY).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}


}
