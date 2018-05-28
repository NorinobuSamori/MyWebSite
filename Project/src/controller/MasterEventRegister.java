package controller;

import java.io.IOException;

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
import templates.Addresses;
//java.appletパッケージをimport宣言
//Graphicsクラスはawtパッケージに属しているのでawtパッケージもimport宣言
//Appletクラスを継承
/**
 * スタート画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/MasterEventRegister")
@MultipartConfig(location="C:\\Users\\Samori-Norinobu\\Documents\\MyWebSite\\Project\\WebContent\\img", maxFileSize=1048576)
public class MasterEventRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
////	 @Override???
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			 request.setCharacterEncoding("UTF-8");
			 System.out.println("MasterEventRegister utf-8宣言直後");

			Addresses.SysoCheck();
			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_REGISTER);
			dispatcher.forward(request, response);


			Addresses.SysoCheck();
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}








	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          	request.setCharacterEncoding("UTF-8");

          	Part part = request.getPart("upLoadFileName");
          	String name = this.getFileName(part);////下記のメソッドへジャンプ  確か、ファイルを取り扱うメソッドとのこと。
          	part.write(name);



          	String title = request.getParameter("title");
    		////String upLoadFileName = request.getParameter("upLoadFileName");ではない
    		//System.out.println(name);
    		String summary = request.getParameter("summary");
    		String event_category = request.getParameter("event_category");
    		String schedule = request.getParameter("schedule");
    		String local_region = request.getParameter("local_region");
    		String fees = request.getParameter("fees");
    		String access = request.getParameter("access");
    		String qualification = request.getParameter("qualification");
    		String presenter = request.getParameter("presenter");
    		String organizer = request.getParameter("organizer");

    		EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
    		boolean result = eventDetailInfoDao.InsertOneEventDetailInfo(title, name, summary, event_category,
    	    		schedule, local_region, fees, access, qualification, presenter,
    	    		organizer);

    		if(result == false) {
    			request.setAttribute("errMsg", "入力された内容は正しくありません、もしくはMySQL上でエラーが起きております");
    			RequestDispatcher dispatcher = request.getRequestDispatcher(Addresses.MASTER_EVENT_REGISTER);
    			dispatcher.forward(request, response);
    			return;
    		}

    		//エラーが無かった場合
    		response.sendRedirect("Index");


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
