package com.ers.util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import com.ers.util.PropertiesParser;

	public class ConnectionFactory {
	
		private final static String URL = PropertiesParser.dbDetails.get("url");
		private final static String USERNAME = PropertiesParser.dbDetails.get("username");
		private final static String PASSWORD = PropertiesParser.dbDetails.get("password");

		public Connection getConnection() throws SQLException {

			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			return conn;

		}
	}

