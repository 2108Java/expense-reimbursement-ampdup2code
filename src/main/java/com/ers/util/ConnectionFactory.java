package com.ers.util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import com.ers.util.PropertiesParser;

	public class ConnectionFactory {
		
		
	
		private final static String URL = PropertiesParser.dbDetails.get("url");
		private final static String USERNAME = PropertiesParser.dbDetails.get("username");
		private final static String PASSWORD = PropertiesParser.dbDetails.get("password");
		
//		private final static String URL = "jdbc:postgresql://expense-reimbersment-project-1.crtqdgrkyvxb.us-east-2.rds.amazonaws.com/";
//		private final static String USERNAME = "postgres";
//		private final static String PASSWORD = "Password";

		public Connection getConnection() throws SQLException {

			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			return conn;

		}
	}

