package de.conet.techtalk.simplewebapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.conet.techtalk.simplewebapp.DbConnector;
import de.conet.techtalk.simplewebapp.model.Stunden;
import de.conet.techtalk.simplewebapp.model.User;

@WebServlet(name = "MainServlet", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6372320689742676767L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(ServletUtil.checkUserLoggedIn(req.getSession())) {
			User user = (User) req.getSession().getAttribute("user");
			
			String searchProject = req.getParameter("searchProjekt");
			String searchComment = req.getParameter("searchComment");
			
			List<Stunden> items = DbConnector.getStunden(user, searchProject, searchComment);
			req.setAttribute("items", items);
			getServletContext().getRequestDispatcher("/main.jsp").forward(req, res);
		} else {
			getServletContext().getRequestDispatcher("/root").forward(req, res);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
