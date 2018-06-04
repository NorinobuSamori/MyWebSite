package controller;

//モデルはSignUpServlet.java

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
@WebServlet("/UserInfoUpdate")
public class UserInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUpdate() {
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
				session.setAttribute("returnStrUrl", "UserInfoUpdate");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}


			String id = request.getParameter("id");


			UserInfoDao UserInfoDao = new UserInfoDao();
			BeansUserInfo BeansUserInfoDetail = UserInfoDao.findByDetailInfo(id);

			session.setAttribute("BeansUserInfoScope", BeansUserInfoDetail);

			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.USER_INFO_UPDATE);
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
			////ログインセッション確認
			BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
			if (beansUserInfoAccount == null) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "UserInfoUpdate");
				// Login画面にリダイレクト
				response.sendRedirect("SiteLogin");
				return;
			}
			String id = request.getParameter("id");
			String login_id = request.getParameter("login_id");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String birth_date = request.getParameter("birth_date");

			if(id.equals("") || login_id.equals("") || name.equals("") || birth_date.equals("")){
				request.setAttribute("errMsg", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userinfoupdate.jsp");
				dispatcher.forward(request, response);
				return;
			}
		if(!password1.equals(password2)) {////	!=ではないので要注意
				request.setAttribute("errMsg", "パスワードと確認用パスワードが一致しておりません");
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userinfoupdate.jsp");
				dispatcher.forward(request, response);
				return;
			}


			UserInfoDao UserInfoDao = new UserInfoDao();
			BeansUserInfo BeansUserInfoDetail = UserInfoDao.findByDetailInfo(id);

			session.setAttribute("BeansUserInfoScope", BeansUserInfoDetail);


			UserInfoDao UserInfoDao2 = new UserInfoDao();
			UserInfoDao2.byUpdateInfo(login_id, password1, name, birth_date);


			response.sendRedirect("UserInfoManagementTop");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}