package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventDetailInfoDao;
import model.BeansEventDetailInfo;

/**
 * Servlet implementation class SiteDeleteFromCart
 */
@WebServlet("/SiteDeleteFromCart")
public class SiteDeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteDeleteFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			//AddtoCartボタンによって送信されたevent_idに紐づいているevent1つを取り出す
			String event_id = request.getParameter("event_id");
			EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
			BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);




			//inCartEventListをセッション取得
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("beansEventDetailInfoList");



			//カート内に同じ商品が入っていたら、リストから削除
			for(int i = 0 ; i < beansEventDetailInfoList.size() ; i++) {
				if(beansEventDetailInfoList.get(i).getId() == beansEventDetailInfo.getId()) {
					//リストから(i)番目を削除
					beansEventDetailInfoList.remove(i);
				}
			}

			//最後にカートリストをセッションセット
			session.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);

			//最後にリダイレクト
			session.setAttribute("deleteFromCartActionMessage", "カートからイベントを削除しました");
			System.out.println("SiteDeleteFromCartからSiteInCartにエラーなくリダイレクト");
			response.sendRedirect("SiteInCart");


		} catch (Exception e) {
			System.out.println("Error on SiteDeleteFromCart");
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}




}
