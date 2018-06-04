package templates;

import javax.servlet.http.HttpSession;

public class ProcessSession {
	public static Object cutSessionReturnString(HttpSession session, String str) {

		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}
}
