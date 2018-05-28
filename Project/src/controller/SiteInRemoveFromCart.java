package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventDetailInfoDao;
import templates.Addresses;

/**
 * Servlet implementation class SiteInRemoveFromCart
 */
@WebServlet("/SiteInRemoveFromCart")
public class SiteInRemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteInRemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();


		try {
			//AddtoCartボタンによって送信されたevent_idに紐づいているevent1つを取り出す
			String event_id = request.getParameter("event_id");
			EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
//			BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);


			//未実装状態

			//メッセージとともにjspへリダイレクト
			request.setAttribute("smallActionMessage", "カートからイベントを削除しました");
			request.getRequestDispatcher(Addresses.SITE_IN_CART).forward(request, response);


			//対象のアイテム情報を取得
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}


	}

}
