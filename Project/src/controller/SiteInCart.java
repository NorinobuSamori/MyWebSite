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
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("beansEventDetailInfoList");



			//セッションにカートがない場合、JSP側の特殊処理により、レジに進むボタンを消す
			if(beansEventDetailInfoList == null) {
				String actionMessage = "カートにイベントがありません";
				String cartNullBySiteInCart = null;
				System.out.println(actionMessage);
				request.setAttribute("actionMessage", actionMessage);
				request.setAttribute("cartNullBySiteInCart", cartNullBySiteInCart);
				request.getRequestDispatcher(Addresses.SITE_IN_CART).forward(request, response);
				System.out.println("siteincart"+cartNullBySiteInCart);
			}else {
				String cartNullBySiteInCart = "カート != null";
				request.setAttribute("cartNullBySiteInCart", cartNullBySiteInCart);
			}




			String actionMessage = "";

			//JSP側カートボタン表示特殊処理用
			String cartAction = "cartAction";
			request.setAttribute("cartAction", cartAction);

			//カートイベント重複エラー表示用
			String cartErrorActionMessage = (String) session.getAttribute("cartErrorActionMessage");
			if(cartErrorActionMessage != null) {
				//AddToCartにて重複エラーが起きていた場合
				session.removeAttribute("cartErrorActionMessage");
				request.setAttribute("errorMessage", cartErrorActionMessage);
			}

			//イベント追加成功用
			String cartActionMessage = (String) session.getAttribute("cartActionMessage");
			if(cartActionMessage != null) {
				session.removeAttribute("cartActionMessage");
				request.setAttribute("actionMessage", cartActionMessage);
			}

			//イベント削除成功用//cutSessionReturnStringを利用する必要あり
			//イベント追加を同じ時系列で扱っているので不具合発生
			String deleteFromCartActionMessage = (String) session.getAttribute("deleteFromCartActionMessage");
			if(deleteFromCartActionMessage != null) {
				session.removeAttribute("deleteFromCartActionMessage");
				request.setAttribute("actionMessage", deleteFromCartActionMessage);
			}


			request.getRequestDispatcher(Addresses.SITE_IN_CART).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			System.out.println("Error on SiteInCart.java");
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
