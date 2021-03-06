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
 * Servlet implementation class SiteAddToCart
 */


////モデルはItemAdd.java
@WebServlet("/SiteAddToCart")
public class SiteAddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteAddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			//AddtoCartボタンによって送信されたevent_idに紐づいているevent1つを取り出す
			String event_id = request.getParameter("event_id");
			EventDetailInfoDao eventDetailInfoDao = new EventDetailInfoDao();
			BeansEventDetailInfo beansEventDetailInfo  = eventDetailInfoDao.SelectOneEventDetailInfo(event_id);

			request.setAttribute("beansEventDetailInfo", beansEventDetailInfo);



			//inCartEventListをセッション取得
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("beansEventDetailInfoList");
			//セッションにカートがない場合カートを作成
			if (beansEventDetailInfoList == null) {
				beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();
			}


			//カートにすでに同じ商品が入っているかどうかの確認
			for(int i = 0 ; i < beansEventDetailInfoList.size() ; i++) {
				if(beansEventDetailInfoList.get(i).getId() == beansEventDetailInfo.getId()) {
					session.setAttribute("cartErrorActionMessage", "カートに同じイベントがすでに入っております");
					System.out.println("SiteAddToCartからSiteInCartに、イベント重複エラーによるリダイレクト");
					response.sendRedirect("SiteInCart");
					return;
				}
			}

			//inCartEventListに加えて再びinCartEventListセッションをセットする
			beansEventDetailInfoList.add(beansEventDetailInfo);
			session.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);



			//エラーが無かった場合
			session.setAttribute("cartActionMessage", "イベントを追加しました");
			System.out.println("SiteAddToCartからSiteInCartにエラーなくリダイレクト");
			response.sendRedirect("SiteInCart");


			//対象のアイテム情報を取得
		} catch (Exception e) {
			System.out.println("SiteAddToCart内エラー");
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
