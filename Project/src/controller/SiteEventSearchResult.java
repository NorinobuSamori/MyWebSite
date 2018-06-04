package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoEventSearch;
import model.BeansEventDetailInfo;
import templates.Addresses;

/**
 * Servlet implementation class SiteEventSearchResult
 */
@WebServlet("/SiteEventSearchResult")
public class SiteEventSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteEventSearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

  //1ページに表示する商品数
  	final static int PAGE_MAX_ITEM_COUNT = 8;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String searchWord = request.getParameter("search_word");
			//表示ページ番号 未指定の場合 1ページ目を表示
			int pageNum = Integer.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
System.out.println("33331111");
			// 新たに検索されたキーワードをセッションに格納する
			session.setAttribute("searchWord", searchWord);
System.out.println("44441111");

			// 商品リストを取得 ページ表示分のみ
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = DaoEventSearch.getInstance().getAllSearchEventDetail(searchWord, pageNum, PAGE_MAX_ITEM_COUNT);
System.out.println("55551111");
			// 検索ワードに対しての総ページ数を取得
			double eventCount = DaoEventSearch.getAllEventDetailCount(searchWord);
System.out.println("66661111");
			int pageMax = (int) Math.ceil(eventCount / PAGE_MAX_ITEM_COUNT);
System.out.println("77771111");

			//総アイテム数
			request.setAttribute("eventCount", (int) eventCount);
			// 総ページ数
			request.setAttribute("pageMax", pageMax);
			// 表示ページ
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("beansEventDetailInfoList", beansEventDetailInfoList);

			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("searchWord" +" = "+ searchWord);
			System.out.println("eventCount" +" = "+ eventCount);
			System.out.println("pageMax" +" = "+ pageMax);
			System.out.println("pageNum" +" = "+ pageNum);
			System.out.println("beansEventDetailInfoList" +" = "+ beansEventDetailInfoList);



			request.getRequestDispatcher(Addresses.SITE_EVENT_SEARCH_RESULT).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
