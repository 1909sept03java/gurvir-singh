package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;

public interface DepartmentDAO {
	
	public List<Department> getDepartment();
	public Department getDepartmentById(int id);
	public void printDepartmentAvg();
	public void raiseSalary(int id);

}
