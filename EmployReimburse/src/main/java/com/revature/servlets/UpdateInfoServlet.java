  package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class UpdateInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		EmployeeDAO employ = new EmployeeDAOImpl();
		Employee e = employ.getEmployeeById(Integer.parseInt(session.getAttribute("employeeId").toString()));
		System.out.println(req.getParameter("email"));
		e.setEmail(req.getParameter("email"));
		e.setPassword(req.getParameter("password"));
		employ.updateEmployeeInfo(e);
		session.setAttribute("email", req.getParameter("email"));
		session.setAttribute("password", req.getParameter("password"));
		resp.sendRedirect("profile");
	}
}