package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class SubmitReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			if (session.getAttribute("employeeId").equals(1) || session.getAttribute("employeeId").equals(2)) {
				req.getRequestDispatcher("ManagerRequest.html").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("Requests.html").forward(req, resp);
			}
			
		} else {
			resp.sendRedirect("login");
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		int id = Integer.parseInt(session.getAttribute("employeeId").toString());
		String detail = req.getParameter("detail");
		if(req.getParameter("amount") != null && req.getParameter("detail") != null) {
			ReimbursementDAO rd = new ReimbursementDAOImpl();
			System.out.println("This happens!!");
			rd.createReimbursements(amount, id, detail);
		
		}
		
		resp.sendRedirect("request");
		
	}

}