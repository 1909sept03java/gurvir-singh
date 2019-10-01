package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			if (session.getAttribute("employeeId").equals(1) || session.getAttribute("employeeId").equals(2)) {
				req.getRequestDispatcher("ManagerHome.html").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("EmployeeHome.html").forward(req, resp);
			}
			
		} else {
			resp.sendRedirect("login");
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}