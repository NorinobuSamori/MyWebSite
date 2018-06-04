package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoEventSearch;
import model.BeansEventDetailInfo;
import templates.Addresses;

/**
 * スタート画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {

			DaoEventSearch daoEventSearch = new DaoEventSearch();
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = daoEventSearch.SelectAllEventsByRandom(6);


			request.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);


			//セッションにsearchWordが入っていたら破棄する
			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}




			request.getRequestDispatcher(Addresses.TOP_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("Error catch on Index");
			response.sendRedirect("Error");
		}
	}
}
