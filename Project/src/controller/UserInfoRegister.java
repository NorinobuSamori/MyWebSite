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
import templates.Addresses;

/**
 * Servlet implementation class SiteLogin
 */
@WebServlet("/UserInfoRegister")
public class UserInfoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoRegister() {
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



			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.USER_INFO_REGISTER);
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
			String login_id = request.getParameter("login_id");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String birth_date = request.getParameter("birth_date");

			if(login_id.equals("") || password1.equals("") || password2.equals("") || name.equals("") || birth_date.equals("")){////nullではない
				request.setAttribute("errorMessage", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
				dispatcher.forward(request, response);
				return;
			}


			if(!password1.equals(password2)) {////	!=ではないので要注意
				request.setAttribute("errorMessage", "パスワードと確認用パスワードが一致しておりません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
				dispatcher.forward(request, response);
				return;
			}

			UserInfoDao UserInfoDao = new UserInfoDao();
			boolean result = UserInfoDao.SignUpInfo(login_id, password1, name, birth_date);

			if(result == false) {
				request.setAttribute("errorMessage", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
				dispatcher.forward(request, response);
				return;
			}


			response.sendRedirect("UserInfoManagementTop");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}