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
		resp.getWriter().append("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>JSp</title>""");
		var dispatcher = req.getRequestDispatcher("bootstrap.jsp");
		dispatcher.include(req, resp);
		
		resp.getWriter().append("""
				</head>
				<body>
					<div class="container mt-3">
						<h1>Hello Jsp without xml</h1>
						
							<a href="./" class="btn btn-primary">Home</a>
					</div>
				</body>
				</html>
				""");
	}

}
