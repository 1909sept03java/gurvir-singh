package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.service.ConnectionService;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getReimbursements() {
		
		List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int reimburseId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				int status = rs.getInt("R_STATUS");
				int employId = rs.getInt("EMPLOYEE_ID");
				String detail = rs.getString("DETAILS");
				allReimbursements.add(new Reimbursement(reimburseId, amount, status, employId, detail));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return allReimbursements;
		
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployId(int employId) {
		
		List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int reimburseId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				int status = rs.getInt("R_STATUS");
				String detail = rs.getString("DETAILS");
				allReimbursements.add(new Reimbursement(reimburseId, amount, status, employId, detail));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return allReimbursements;
		
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		
		List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE R_STATUS = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int reimburseId = rs.getInt("R_ID");
				double amount = rs.getDouble("R_AMOUNT");
				int employId = rs.getInt("EMPLOYEE_ID");
				String detail = rs.getString("DETAILS");
				allReimbursements.add(new Reimbursement(reimburseId, amount, status, employId, detail));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return allReimbursements;
		
	}

	@Override
	public void createReimbursements(double amount, int employId, String detail) {
		
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "INSERT INTO REIMBURSEMENT VALUES(1, ?, 0, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, employId);
			ps.setString(2, detail);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	@Override 
	public void resolveReimbursements(int reimburseId, int status) {
	
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE REIMBURSEMENT SET R_STATUS = ? WHERE R_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, reimburseId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
