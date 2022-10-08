package com.project.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect {
	public static Connection connection;
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String uesrname = "root";
			String password = "";
			String url ="jdbc:mysql://localhost:3307/project";
			   	
			connection = DriverManager.getConnection(url, uesrname, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

