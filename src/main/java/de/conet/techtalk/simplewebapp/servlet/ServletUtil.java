package de.conet.techtalk.simplewebapp.servlet;

import javax.servlet.http.HttpSession;

public class ServletUtil {
	public static boolean checkUserLoggedIn(HttpSession session) {
		return Boolean.TRUE.equals(session.getAttribute("login"));
	}

	public static boolean isValidString(String string) {
		return string != null && string.length() > 0 && string.length() < 20;
	}
	
	public static boolean isValid(String string) {
		return string.indexOf('-') < 0 || string.indexOf(';') < 0 || string.indexOf('"') < 0 ||
				string.indexOf('\'') < 0 || string.indexOf('(') < 0 || string.indexOf(')') < 0;
	}
}
