package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventDetailInfoDao;
import model.BeansEventDetailInfo;
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
		HttpSession session = request.getSession();


		String event_id = request.getParameter("event_id");

		//詳細表サンプル表示用、
		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
		BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);
		session.setAttribute("beansEventDetailInfo", beansEventDetailInfo);

		//概要表サンプル表示用
		ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();
		beansEventDetailInfoList = eventDetailInfoDao.SelectOneListEventDetailInfo(event_id);
		session.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);


		RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_DELETE);
		dispatcher.forward(request, response);


	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		String event_id = request.getParameter("event_id");

		//対象のイベントテーブル1行をimageとともにDeleteする
		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
		eventDetailInfoDao.DeleteOneEventDetailInfoById(event_id);


		request.setAttribute("actionMessage","イベント削除に成功しました");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Index");
		dispatcher.forward(request, response);






	}

}
