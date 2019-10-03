package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			Employee employ = new Employee();
			employ.setEmployeeId(Integer.parseInt(session.getAttribute("employeeId").toString()));
			employ.setUsername(session.getAttribute("username").toString());
			employ.setPassword(session.getAttribute("password").toString());
			employ.setEmail(session.getAttribute("email").toString());
			employ.setManagerId(Integer.parseInt(session.getAttribute("managerId").toString()));
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(employ));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

}