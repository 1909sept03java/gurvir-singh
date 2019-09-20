package project.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.beans.Account;
import project.exceptions.BankException;
import project.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> getAccounts() {
		List<Account> a = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNT";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int accountID = rs.getInt("ACCOUNT_ID");
				int accountNum = rs.getInt("ACCOUNT_NUM");
				double balance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USER_ID");
				a.add(new Account(accountID, accountNum, balance, userID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Account> getAccountsByID(int id) {
		List<Account> a = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int accountID = rs.getInt("ACCOUNT_ID");
				int accountNum = rs.getInt("ACCOUNT_NUM");
				double balance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USER_ID");
				a.add(new Account(accountID, accountNum, balance, userID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void createAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ACCOUNT VALUES(10, ?, ?, 10)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, account.getBalance());
			pstmt.setInt(2, account.getUserID());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccount(int accountNum, double balance) throws BankException {
		if (balance != 0) {
			throw new BankException("The balance isn't 0. Would you like to withdraw it all? Enter 1 for yes or hit just enter for main menu");
		}
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountNum);
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double transacation(int accountNum, double amount) {
		double newBal = 0.0;
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "{call CHANGE_BALANCE(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, accountNum);
			cs.setDouble(2, amount);
			cs.registerOutParameter(3,java.sql.Types.DECIMAL);
			cs.execute();
			newBal = cs.getDouble(3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newBal;
	}

	
}
