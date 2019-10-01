package com.revature.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionService {

	public static Connection getConnection() throws SQLException, IOException {
		
		Properties prop = new Properties();
		
		prop.load(ConnectionService.class.getClassLoader().getResourceAsStream("connection.properties"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}