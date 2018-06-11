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
import templates.ProcessSession;

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
		ProcessSession processSession = new ProcessSession();
		try {

			DaoEventSearch daoEventSearch = new DaoEventSearch();
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = daoEventSearch.SelectAllEventsByRandom(20);


			request.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);


			//セッションにsearchWordが入っていたら破棄する
			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}


			//Loginサーブレット上にあるreturnStrUrlセッションをremoveする
			session.removeAttribute("returnStrUrl");













			//イベント新規登録成功用
			String eventRegistActionMessage = (String) processSession.cutSessionReturnString(session, "eventRegistActionMessage");
			if(eventRegistActionMessage != null) {
				request.setAttribute("actionMessage", eventRegistActionMessage);
				System.out.println("actionMessage = " + eventRegistActionMessage + "on Index.java" );
				request.getRequestDispatcher(Addresses.TOP_PAGE).forward(request, response);
				return;
			}


			//イベント更新登録成功用
			String eventUpdateActionMessage = (String) processSession.cutSessionReturnString(session, "eventUpdateActionMessage");
			if(eventUpdateActionMessage != null) {
				request.setAttribute("actionMessage", eventUpdateActionMessage);
				System.out.println("actionMessage = " + eventUpdateActionMessage + "on Index.java" );
				request.getRequestDispatcher(Addresses.TOP_PAGE).forward(request, response);
				return;
			}



			//イベント削除成功用
			String eventDeleteActionMessage = (String) processSession.cutSessionReturnString(session, "eventDeleteActionMessage");
			if(eventDeleteActionMessage != null) {
				request.setAttribute("actionMessage", eventDeleteActionMessage);
				System.out.println("actionMessage = " + eventDeleteActionMessage + "on Index.java" );
				request.getRequestDispatcher(Addresses.TOP_PAGE).forward(request, response);
				return;
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
