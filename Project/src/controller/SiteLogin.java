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
import templates.ProcessSession;

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
		ProcessSession processSession = new ProcessSession();
		BeansUserInfo beansUserInfoAccount = (BeansUserInfo)session.getAttribute("beansUserInfoAccount");
		if(beansUserInfoAccount != null){
				System.out.println("SiteLoginからIndexへリダイレクト");
				response.sendRedirect("Index");
				return;
		}


		//ログアウト用
		String logoutActionMessage = (String) processSession.cutSessionReturnString(session, "logoutActionMessage");
		if(logoutActionMessage != null) {
			request.setAttribute("actionMessage", logoutActionMessage);
			System.out.println("actionMessage = " + logoutActionMessage + "on SiteLogin.java" );
			request.getRequestDispatcher(Addresses.SITE_LOGIN).forward(request, response);
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
				request.setAttribute("errorMessage", "ログインIDまたはパスワードが異なります");
				System.out.println("errorMessageログインページへ on SiteLogin");
				// ログインjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.SITE_LOGIN);
				dispatcher.forward(request, response);
				return;
			}



			beansUserInfoAccount = UserInfoDao.SelectAllByLogin_id(login_id);
			session.setAttribute("beansUserInfoAccount", beansUserInfoAccount);





			String returnStrUrl = (String) session.getAttribute("returnStrUrl");
			System.out.println("SiteLoginから、" + "returnStrUrlである" + returnStrUrl + "にリダイレクト");
			session.removeAttribute(returnStrUrl);






			response.sendRedirect(returnStrUrl!=null?returnStrUrl:"Index");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("on sitelogin catch post");
			response.sendRedirect("Error");
		}


	}

}
