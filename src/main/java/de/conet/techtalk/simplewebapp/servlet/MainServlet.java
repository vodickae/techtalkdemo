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

@WebServlet(name = "MainServlet", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6372320689742676767L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Stunden> items = DbConnector.getStunden();
		
		req.setAttribute("items", items);
		
		getServletContext().getRequestDispatcher("/main.jsp").forward(req, res);
	}
	
}
