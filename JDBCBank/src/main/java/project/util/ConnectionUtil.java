package project.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	
	}

}