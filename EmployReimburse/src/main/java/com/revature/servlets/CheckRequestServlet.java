  package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class CheckRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
				req.getRequestDispatcher("Reimbursements.html").forward(req, resp);
			
		} else {
			resp.sendRedirect("login");
			
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status;
		int id = Integer.parseInt(req.getParameter("reimburseId"));
		if(req.getParameter("option").equals("Deny")) {
			status = 2;
		} else
			status = 1;
		
		ReimbursementDAO rd = new ReimbursementDAOImpl();
		rd.resolveReimbursements(id, status);
		resp.sendRedirect("resolve");
		
	}
	
}