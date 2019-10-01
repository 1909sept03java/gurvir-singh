package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuthenticationService authService = new AuthenticationService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		Employee employ = authService.authenticateUser(creds);
		if (employ != null) {
			session.setAttribute("employeeId", employ.getEmployeeId());
			session.setAttribute("username", employ.getUsername());
			session.setAttribute("password", employ.getPassword());
			session.setAttribute("email", employ.getEmail());
			session.setAttribute("managerId", employ.getManagerId());
			resp.sendRedirect("profile");
			
		} else {
			session.setAttribute("problem", "Invalid Credentials");
			resp.sendRedirect("login");
			
		}
		
	} 
	
}