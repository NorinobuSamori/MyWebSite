package controller;

/////モデルはSignUpServlet.java

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import model.BeansUserInfo;
import templates.Addresses;

/**
 * Servlet implementation class SiteLogin
 */
@WebServlet("/UserInfoDetail")
public class UserInfoDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoDetail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			////ログインセッション確認
			BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "UserInfoDetail");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}


			String id = request.getParameter("id");


			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserInfoDao UserInfoDao = new UserInfoDao();
			BeansUserInfo BeansUserInfoDetail = UserInfoDao.findByDetailInfo(id);


			session.setAttribute("BeansUserInfoScope", BeansUserInfoDetail);


			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.USER_INFO_DETAIL);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {

			// リクエストパラメータの入力項目を取得
			String id = request.getParameter("id");

			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserInfoDao UserInfoDao = new UserInfoDao();
			BeansUserInfo BeansUserInfoDetail = UserInfoDao.findByDetailInfo(id);


			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserInfoManagementTop");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}