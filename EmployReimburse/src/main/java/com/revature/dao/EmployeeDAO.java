package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public List<Employee> getEmployeeByManager(int managerId);
	public Employee getEmployeeById(int employeeId);
	public void updateEmployeeInfo(Employee employ);

}
