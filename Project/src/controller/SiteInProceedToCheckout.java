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
import model.BeansUserInfo;
import templates.Addresses;
import templates.GetTotalFeesOfEvents;

/**
 * Servlet implementation class SiteProceedToCheckout
 */


////モデルはBuyConfirm.java



@WebServlet("/SiteInProceedToCheckout")
public class SiteInProceedToCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteInProceedToCheckout() {
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

				////ログインセッション確認
				BeansUserInfo beansUserInfoAccount = (BeansUserInfo) session.getAttribute("beansUserInfoAccount");
				if (beansUserInfoAccount == null) {
					// Sessionにリターンページ情報を書き込む
					session.setAttribute("returnStrUrl", "SiteInProceedToCheckout");
					// Login画面にリダイレクト
					response.sendRedirect("SiteLogin");
					return;
				}


				//最初に買い物かごセッションを取得
				ArrayList<BeansEventDetailInfo> inCartBeansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("inCartBeansEventDetailInfoList");

				//合計金額をgetしてsetする
				int totalFees = GetTotalFeesOfEvents.getTotalItemPrice(inCartBeansEventDetailInfoList);
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				beansEventDetailInfo.setTotal_fees(totalFees);

//				beansEventDetailInfo.setUserId((int) session.getAttribute("userId"));



				//合計金額表示で利用
				session.setAttribute("beansEventDetailInfo", beansEventDetailInfo);
				request.getRequestDispatcher(Addresses.SITE_IN_PROCEED_TO_CHECKOUT).forward(request, response);
			} catch (Exception e) {
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
