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
import com.revature.beans.MyEmployees;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class MyEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			ReimbursementDAO rd = new ReimbursementDAOImpl();
			List<MyEmployees> employ = new ArrayList<MyEmployees>();
			for(Reimbursement r : rd.getReimbursements()) {
				EmployeeDAO employee = new EmployeeDAOImpl();
				Employee e = employee.getEmployeeById(r.getEmployId()); 
				if (e.getManagerId() == Integer.parseInt(session.getAttribute("employeeId").toString())) {
					String username = e.getUsername();
					String status ="";
					if (r.getStatus() == 0) {
						status = "Pending";
					} else if (r.getStatus() == 1) {
						status = "Approved";
					} else if (r.getStatus() == 2) {
						status = "Declined";
					} 
					double amount = r.getAmount();
					String detail = r.getDetail();
					int id = r.getEmployId();
					MyEmployees allReim = new MyEmployees(username, status, amount, detail, id);
					employ.add(allReim);
				
				}
				
			}
			
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(employ));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		
	}

}