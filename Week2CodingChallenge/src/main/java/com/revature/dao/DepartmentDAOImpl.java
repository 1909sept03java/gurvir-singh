package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public List<Department> getDepartment() { //Test if connections works with this method. 
		List<Department> d1 = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM DEPARTMENT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int departmentID = rs.getInt("DEPARTMENT_ID");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				d1.add(new Department(departmentID, departmentName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Connection good"); //Connection works. 
		return d1;

	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printDepartmentAvg() {
		System.out.println("it works");
		
	}

	@Override
	public void raiseSalary(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
