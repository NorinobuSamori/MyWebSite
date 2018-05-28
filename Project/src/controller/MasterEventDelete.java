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
 * Servlet implementation class MasterEventDelete
 */
@WebServlet("/MasterEventDelete")
public class MasterEventDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterEventDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		String id = request.getParameter("id");


		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
		boolean result = eventDetailInfoDao.DeleteOneEventDetailInfoById(id);

		if(result == false) {
			request.setAttribute("errMsg","error");
			System.out.println("BooleanResult == false about Delete on DeleteOneEventDetailInfoById(id); at MasterEventDelete.java");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_DELETE);
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Index");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");








	}

}
