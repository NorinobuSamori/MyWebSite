package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class
 */
@WebServlet("/UserInfoManagementTop")////hitto
public class UserInfoManagementTop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoManagementTop() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			////ログインセッション確認
			BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "UserInfoManagementTop");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}
			// ユーザ一覧情報を取得
			UserInfoDao UserInfoDao = new UserInfoDao();
			List<BeansUserInfo> beansUserInfoList = UserInfoDao.findAll();


			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("beansUserInfoList", beansUserInfoList);


			// ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.USER_INFO_MANAGEMENT_TOP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("Error on uimt");
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			////ログインセッション確認
			BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "UserInfoManagementTop");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}


			String login_id = request.getParameter("login_id");
			String name = request.getParameter("name");
			String calendar1 = request.getParameter("calendar1");
			String calendar2 = request.getParameter("calendar2");



			UserInfoDao UserInfoDao = new UserInfoDao();
			List<BeansUserInfo> searchList = UserInfoDao.findSearch(login_id, name, calendar1, calendar2);
			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("beansUserInfoList", searchList);

			// ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.USER_INFO_MANAGEMENT_TOP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("error on uimt post");
			response.sendRedirect("Error");
		}

	}

}
