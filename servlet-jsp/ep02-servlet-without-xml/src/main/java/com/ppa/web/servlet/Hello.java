package com.ppa.web.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name = "helloServlet",
		urlPatterns = "/servlet",
		loadOnStartup = 1
		)
public class Hello extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("contextPath",req.getContextPath());
		req.setAttribute("servletPath", req.getServletPath());
		req.setAttribute("severPort", req.getServerPort());
		
		var dispatcher = req.getRequestDispatcher("include.jsp");
		dispatcher.include(req, resp);
		
		
	}

}
