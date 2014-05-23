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
import de.conet.techtalk.simplewebapp.model.Stunden;
import de.conet.techtalk.simplewebapp.model.User;

@WebServlet(name = "DetailServlet", urlPatterns = { "/detail" })
public class DetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7758179283921134442L;
	
	private static final String SQL_GET_STUNDEN = "select * from stunden where id = %s";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(ServletUtil.checkUserLoggedIn(req.getSession())) {
			String stundenId = req.getParameter("id").toString();
			User user = (User) req.getSession().getAttribute("user");
			
			Connection connection = DbConnector.getConnection();
			try {
				Statement statement = connection.createStatement();
				statement.execute(String.format(SQL_GET_STUNDEN, stundenId));
				ResultSet result = statement.getResultSet();
				result.first();
				Stunden stunden = DbConnector.mapStunden(result);
				
				if(stunden.getUserid() == user.getId() || stunden.isFreigegeben()) {
					req.setAttribute("item", stunden);
					getServletContext().getRequestDispatcher("/detail.jsp").forward(req, res);
				} else {
					getServletContext().getRequestDispatcher("/main").forward(req, res);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/main").forward(req, res);
		} else {
			getServletContext().getRequestDispatcher("/root").forward(req, res);
		}
	}
}
