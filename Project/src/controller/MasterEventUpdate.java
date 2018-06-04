package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.EventDetailInfoDao;
import model.BeansEventDetailInfo;
import templates.Addresses;

/**
 * Servlet implementation class MasterEventUpdate
 */
@WebServlet("/MasterEventUpdate")
@MultipartConfig(location="C:\\Users\\Samori-Norinobu\\Documents\\MyWebSite\\Project\\WebContent\\img", maxFileSize=1048576)
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String event_id = request.getParameter("event_id");



		RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_UPDATE);
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		try {
			String event_id = request.getParameter("event_id");
			String title = request.getParameter("title");
			String summary = request.getParameter("summary");
			String event_category = request.getParameter("event_category");
			String schedule = request.getParameter("schedule");
			String local_region = request.getParameter("local_region");
			String fees = request.getParameter("fees");
			String access = request.getParameter("access");
			String qualification = request.getParameter("qualification");
			String presenter = request.getParameter("presenter");
			String organizer = request.getParameter("organizer");

			Part part = request.getPart("upLoadFileName");
			String name = this.getFileName(part);
			part.write(name);

System.out.println("Update aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

			EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
			eventDetailInfoDao.UpdateOneEventDetailInfo(event_id, title, name, summary, event_category,
					schedule, local_region, fees, access, qualification, presenter,
					organizer);


			System.out.println("Update bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");


			//詳細表サンプル表示用
			BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);
			session.setAttribute("beansEventDetailInfo", beansEventDetailInfo);

			//概要表サンプル表示用
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();
			beansEventDetailInfoList = eventDetailInfoDao.SelectOneListEventDetailInfo(event_id);
			session.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);


			response.sendRedirect("Index");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("Error on MasterEventUpdate.java catch at post");
			response.sendRedirect("Error");
		}


	}

	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }






}
