package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeansEventDetailInfo;
import templates.Addresses;

/**
 * Servlet implementation class SiteInCart
 */
@WebServlet("/SiteInCart")
public class SiteInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteInCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 ////モデルはCart.java

		 HttpSession session = request.getSession();
		try {
			ArrayList<BeansEventDetailInfo> inCartBeansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("inCartBeansEventDetailInfoList");
			//セッションにカートがない場合カートを作成
			if (inCartBeansEventDetailInfoList == null) {
				inCartBeansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();
				session.setAttribute("inCartBeansEventDetailInfoList", inCartBeansEventDetailInfoList);
			}



			String actionMessage = "";
			//カートに商品が入っていないなら
			if(inCartBeansEventDetailInfoList.size() == 0) {
				actionMessage = "カートにイベントがありません";
			}


			request.getRequestDispatcher(Addresses.SITE_IN_CART).forward(request, response);

		} catch (Exception e) {
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}






	}







	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	}

}
