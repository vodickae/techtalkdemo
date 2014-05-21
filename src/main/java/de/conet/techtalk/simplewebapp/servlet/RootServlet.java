package de.conet.techtalk.simplewebapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RootServlet", urlPatterns = { "/root" })
public class RootServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1555252762007821489L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/root.jsp").forward(req, res);
	}

	
	
	
}
