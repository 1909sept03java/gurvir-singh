package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.service.ConnectionService;

public class EmployeeDAOImpl implements EmployeeDAO {

	public List<Employee> getEmployees() {
		
		List<Employee> allEmploy = new ArrayList<Employee>();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE_D";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("E_ID");
				String username = rs.getString("E_USERNAME");
				String password = rs.getString("E_PASSWORD");
				String email = rs.getString("E_EMAIL");
				int managerId = rs.getInt("MANAGER_ID");
				allEmploy.add(new Employee(employeeId, username, password, email, managerId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return allEmploy;
		
	}

	public List<Employee> getEmployeeByManager(int managerId) {
		
		List<Employee> allEmploy = new ArrayList<Employee>();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE_D WHERE MANAGER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, managerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("E_ID");
				String username = rs.getString("E_USERNAME");
				String password = rs.getString("E_PASSWORD");
				String email = rs.getString("E_EMAIL");
				allEmploy.add(new Employee(employeeId, username, password, email, managerId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return allEmploy;
		
	}

	public Employee getEmployeeById(int employeeId) {
		
		Employee employ = new Employee();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE_D WHERE E_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String username = rs.getString("E_USERNAME");
				String password = rs.getString("E_PASSWORD");
				String email = rs.getString("E_EMAIL");
				int managerId = rs.getInt("MANAGER_ID");
				employ.setEmployeeId(employeeId); 
				employ.setUsername(username);
				employ.setPassword(password);
				employ.setEmail(email);
				employ.setManagerId(managerId);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return employ;
		
	}
	
	public void updateEmployeeInfo(Employee employ) {
		
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "UPDATE EMPLOYEE_D SET E_PASSWORD = ?, E_EMAIL = ? WHERE E_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employ.getPassword());
			pstmt.setString(2, employ.getEmail());
			pstmt.setInt(3, employ.getEmployeeId());
			pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

}
