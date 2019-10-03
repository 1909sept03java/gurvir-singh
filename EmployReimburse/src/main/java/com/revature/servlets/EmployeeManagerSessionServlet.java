package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.EmployeeManager;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeManagerSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			EmployeeDAO ed = new EmployeeDAOImpl();
			List<EmployeeManager> employMan = new ArrayList<EmployeeManager>();
			for(Employee e : ed.getEmployees()) {
				String employee = e.getUsername();
				EmployeeDAO man = new EmployeeDAOImpl();
				Employee m = man.getEmployeeById(e.getManagerId());
				String manager = m.getUsername();
				EmployeeManager allEmploy = new EmployeeManager(employee, manager);
				employMan.add(allEmploy);
				
			}
			
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(employMan));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		
	}

}