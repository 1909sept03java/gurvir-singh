package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ResolveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			ReimbursementDAO rd = new ReimbursementDAOImpl();
			List<Reimbursement> allreimburse = rd.getReimbursementsByStatus(0);
			List<Reimbursement> myResolve = new ArrayList<Reimbursement>();
			for(Reimbursement r: allreimburse) {
				int id = r.getEmployId();
				EmployeeDAO e = new EmployeeDAOImpl();
				Employee employ = e.getEmployeeById(id);
				if(employ.getManagerId() == Integer.parseInt(session.getAttribute("employeeId").toString())) {
					myResolve.add(r);
				}
				
			}
			
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(myResolve));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		
	}

}