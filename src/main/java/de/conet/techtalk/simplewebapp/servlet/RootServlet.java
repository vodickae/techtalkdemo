package de.conet.techtalk.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.conet.techtalk.simplewebapp.DbConnector;
import de.conet.techtalk.simplewebapp.model.User;

@WebServlet(name = "RootServlet", urlPatterns = { "/root" })
public class RootServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1555252762007821489L;
	private static final String SQL_GET_USER = "select * from user where name = '%s' and passwort = '%s'";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(ServletUtil.checkUserLoggedIn(req.getSession())) {
			getServletContext().getRequestDispatcher("/main").forward(req, res);
		} else {
			getServletContext().getRequestDispatcher("/root.jsp").forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pwd = req.getParameter("password");
		
		if(ServletUtil.isValidString(user) && ServletUtil.isValid(user) && 
				ServletUtil.isValidString(pwd) && ServletUtil.isValid(pwd)) {
			User userObj = null;
			if((userObj = getUser(user, pwd)) != null) {
				req.getSession().setAttribute("login", true);
				req.getSession().setAttribute("user", userObj);
				getServletContext().getRequestDispatcher("/main").forward(req, res);
			} else {
				getServletContext().getRequestDispatcher("/root.jsp").forward(req, res);
			}
		} else {
			getServletContext().getRequestDispatcher("/root.jsp").forward(req, res);
		}
	}
	
	private User getUser(String user, String pwd) {
		Connection connection = DbConnector.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.execute(String.format(SQL_GET_USER, user, pwd));
			ResultSet result = statement.getResultSet();
			result.first();
			return DbConnector.mapUser(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
