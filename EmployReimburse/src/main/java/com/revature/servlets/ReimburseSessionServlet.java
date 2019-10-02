package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAOImpl;

public class ReimburseSessionServlet extends HttpServlet {

	private static final long serialVersionUID = -1319793763433572026L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			ReimbursementDAOImpl rd = new ReimbursementDAOImpl();
			List<Reimbursement> allreimburse = rd.getReimbursementsByEmployId(Integer.parseInt(session.getAttribute("employeeId").toString()));
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(allreimburse));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}