package com.revature.main;

import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		/*
		try {
			Connection conn = ConnectionUtil.getConnection();
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		DepartmentDAO dd = new DepartmentDAOImpl();
		dd.getDepartment();
	}
}
