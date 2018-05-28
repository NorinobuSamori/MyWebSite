package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDetailInfoDao;
import model.BeansEventDetailInfo;
import templates.Addresses;

/**
 * Servlet implementation class SiteEventDetailInfo
 */
@WebServlet("/SiteEventDetailInfo")
public class SiteEventDetailInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteEventDetailInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event_id = request.getParameter("event_id");
		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
		BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);

		request.setAttribute("beansEventDetailInfo", beansEventDetailInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.SITE_EVENT_DETAIL_INFO);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
