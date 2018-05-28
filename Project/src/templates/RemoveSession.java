package templates;

import javax.servlet.http.HttpSession;

public class RemoveSession {
	public static Object removeSession(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}
}
