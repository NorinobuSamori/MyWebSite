package templates;

/**
 * 定数保持、処理及び表示簡略化ヘルパークラス
 *
 * @author d-yamaguchi
 *
 */
public class Addresses {

//-----------------------------------------------------------------------SITEシリーズ------------------//


	// ログインページ
	public static final String SITE_LOGIN = "/WEB-INF/jsp/sitelogin.jsp";
	// index
	public static final String TOP_PAGE = "/WEB-INF/jsp/index.jsp";

	public static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";







	public static final String SITE_EVENT_SEARCH_RESULT = "/WEB-INF/jsp/siteeventsearchresult.jsp";



	public static final String SITE_EVENT_DETAIL_INFO = "/WEB-INF/jsp/siteeventdetailinfo.jsp";




	public static final String SITE_IN_CART = "/WEB-INF/jsp/siteincart.jsp";

	public static final String SITE_IN_PROCEED_TO_CHECKOUT = "/WEB-INF/jsp/siteinproceedtocheckout.jsp";

	public static final String SITE_IN_PLACE_USERS_ORDER= "/WEB-INF/jsp/siteinplaceusersorder.jsp";

	public static final String SITE_EVENT_HISTORY = "/WEB-INF/jsp/siteeventhistory.jsp";




//-----------------------------------------------------------------------SITEシリーズ--------------------//
//-----------------------------------------------------------------------MASTERシリーズ------------------//

	public static final String MASTER_EVENT_REGISTER = "/WEB-INF/jsp/mastereventregister.jsp";

	public static final String MASTER_EVENT_CONFIRM = "/WEB-INF/jsp/mastereventconfirm.jsp";

	public static final String MASTER_EVENT_DELETE = "/WEB-INF/jsp/mastereventdelete.jsp";

	public static final String MASTER_EVENT_DETAIL = "/WEB-INF/jsp/mastereventdetail.jsp";

	public static final String MASTER_EVENT_UPDATE = "/WEB-INF/jsp/mastereventupdate.jsp";

	public static final String MASTER_DATA = "/WEB-INF/jsp/masterdata.jsp";

//-----------------------------------------------------------------------MASTERシリーズ------------------//
//-----------------------------------------------------------------------USERMANAGEMENTシリーズ----------//




	public static final String USER_INFO_REGISTER = "/WEB-INF/jsp/userinforegister.jsp";

	public static final String USER_INFO_DELETE = "/WEB-INF/jsp/userinfodelete.jsp";

	public static final String USER_INFO_UPDATE = "/WEB-INF/jsp/userinfoupdate.jsp";

	public static final String USER_INFO_DETAIL = "/WEB-INF/jsp/userinfodetail.jsp";

	public static final String USER_INFO_MANAGEMENT_TOP = "/WEB-INF/jsp/userinfomanagementtop.jsp";


//-----------------------------------------------------------------------USERMANAGEMENTシリーズ----------//
//-----------------------------------------------------------------------その他シリーズ------------------//

	public static final String CHECK_LOGIN_SESSION = "CheckLoginSession";


	public static Addresses getInstance() {
		return new Addresses();
	}

	public static void SysoCheck() {
		System.out.println("SysoTest Clear on Addresses.java");
	}

//-----------------------------------------------------------------------その他シリーズ------------------//

}
