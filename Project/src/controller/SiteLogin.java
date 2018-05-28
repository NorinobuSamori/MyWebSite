package controller;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SiteLogin")
public class SiteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		BeansUserInfo beansUserInfoAccount = (BeansUserInfo)session.getAttribute("beansUserInfoAccount");
		if(beansUserInfoAccount != null){
				System.out.println("一覧リダイレクト");
				response.sendRedirect("Index");
				return;
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.SITE_LOGIN);
		dispatcher.forward(request, response);
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
			String login_id = request.getParameter("login_id");
			String password = request.getParameter("password");


			UserInfoDao UserInfoDao = new UserInfoDao();
			BeansUserInfo beansUserInfoAccount = UserInfoDao.findByLoginInfo(login_id, password);

			/** テーブルに該当のデータが見つからなかった場合 **/
			if (beansUserInfoAccount == null) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");
				System.out.println("errmsgログインページへ on SiteLogin");
				// ログインjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sitelogin.jsp");
				dispatcher.forward(request, response);
				return;
			}
			else {
				beansUserInfoAccount = UserInfoDao.SelectAllByLogin_id(login_id);

				session.setAttribute("beansUserInfoAccount", beansUserInfoAccount);
				String returnStrUrl = (String) session.getAttribute("returnStrUrl");
				response.sendRedirect(returnStrUrl!=null?returnStrUrl:"Index");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}


	}

}
