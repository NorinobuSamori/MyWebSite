package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDetailInfoDao;
import templates.Addresses;

/**
 * Servlet implementation class MasterEventUpdate
 */
@WebServlet("/MasterEventUpdate")
public class MasterEventUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterEventUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		////これを消すと文字化けが無くなる
//				response.getWriter().append("Served at: ").append(request.getContextPath());

		String id = request.getParameter("id");


		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
		boolean result = eventDetailInfoDao.DeleteOneEventDetailInfoById(id);

		if(result == false) {
			request.setAttribute("errMsg","MySQL上でエラーが起きております");
			System.out.println("BooleanResult == false about Delete on DeleteOneEventDetailInfoById(id); at MasterEventDelete.java");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_DELETE);
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Index");
		dispatcher.forward(request, response);

		
		
		
	}

}
