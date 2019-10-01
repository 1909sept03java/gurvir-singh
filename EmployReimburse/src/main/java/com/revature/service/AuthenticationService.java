package com.revature.service;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAOImpl;

public class AuthenticationService {

	public Employee authenticateUser(Credentials creds) {
		EmployeeDAOImpl employDAO = new EmployeeDAOImpl();
		List<Employee> allEmploys = employDAO.getEmployees();
		Employee authorizedEmployee = new Employee();
		for (Employee employ: allEmploys) {
			
			if (employ.getUsername().equals(creds.getUsername()) && employ.getPassword().equals(creds.getPassword())) {
				authorizedEmployee.setEmployeeId(employ.getEmployeeId());
				authorizedEmployee.setUsername(employ.getUsername());
				authorizedEmployee.setPassword(employ.getPassword());
				authorizedEmployee.setEmail(employ.getEmail());
				authorizedEmployee.setManagerId(employ.getManagerId());
				return authorizedEmployee;
				
			}
			
		}
		
		return null;
		
	}
	
}