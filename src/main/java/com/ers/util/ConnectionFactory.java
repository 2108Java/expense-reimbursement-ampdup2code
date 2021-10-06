package com.ers.util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectionFactory {
	
		//private static final String URL = "jdbc:postgresql://" + "localhost" + "/ERS";
		private static final String URL = "jdbc:postgresql://expense-reimbersment-project-1.crtqdgrkyvxb.us-east-2.rds.amazonaws.com/";
		private static final String USERNAME = "postgres";
		private static final String PASSWORD = "Password";

		public Connection getConnection() throws SQLException {

			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			return conn;

		}
	}

