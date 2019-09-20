package project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.beans.User;
import project.exceptions.LoginException;
import project.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> getUsers() {
		List<User> a = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_ID");
				String fName = rs.getString("USER_FIRSTNAME");
				String lName = rs.getString("USER_LASTNAME");
				String uName = rs.getString("USER_USERNAME");
				String pass = rs.getString("USER_PASSWORD");
				String eMail = rs.getString("USER_EMAIL");
				int rank = rs.getInt("RANK_USER");
				a.add(new User(id, fName, lName, uName, pass, eMail, rank));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public User getUserByName(String uName) {
		User a = new User();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BANK_USER WHERE USER_USERNAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("USER_ID");
				String fName = rs.getString("USER_FIRSTNAME");
				String lName = rs.getString("USER_LASTNAME");
				String userName = rs.getString("USER_USERNAME");
				String pass = rs.getString("USER_PASSWORD");
				String eMail = rs.getString("USER_EMAIL");
				int rank = rs.getInt("RANK_USER");
				a.setfName(fName);
				a.setlName(lName);
				a.setuName(uName);
				a.setPass(pass);
				a.seteMail(eMail);
				a.setId(id);
				a.setRank(rank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void checkPass(String username, String pass) throws LoginException {
		boolean passMatch = false;
		UserDAO a = new UserDAOImpl();
			for (User b : a.getUsers()) {
				if (b.getPass().equals(pass))
					passMatch = true;
			}
			if(!passMatch)
				throw new LoginException("Password in incorrect. Try again.");
		
	}
	
	@Override
	public void uniqueUsername(String username) throws LoginException {
			boolean doesExist = false;
			UserDAO a = new UserDAOImpl();
			for (User b : a.getUsers()) {
				if (b.getuName().equals(username))
					doesExist = true;
			}
			if(doesExist)
				throw new LoginException("Username already exits. Enter a different username");			
	}

	@Override
	public void checkUsername(String username) throws LoginException {
			boolean doesExist = false;
			UserDAO a = new UserDAOImpl();
			for (User b : a.getUsers()) {
				if (b.getuName().equals(username))
					doesExist = true;
			}
			if(!doesExist)
				throw new LoginException("Username doesn't exist. Try entering the username again");
				
	}

	@Override
	public void createUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO BANK_USER VALUES(10, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getfName());
			pstmt.setString(2, user.getlName());
			pstmt.setString(3, user.getuName());
			pstmt.setString(4, user.getPass());
			pstmt.setString(5, user.geteMail());
			pstmt.setInt(6, user.getRank());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM BANK_USER WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE BANK_USER SET USER_FIRSTNAME = ?, USER_LASTNAME = ?, USER_USERNAME = ?, USER_PASSWORD = ?, USER_EMAIL = ?, "
					+ "RANK_USER = 2 WHERE USER_ID = ?  ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getfName());
			pstmt.setString(2, user.getlName());
			pstmt.setString(3, user.getuName());
			pstmt.setString(4, user.getPass());
			pstmt.setString(5, user.geteMail());
			pstmt.setInt(6, user.getId());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}