package com.ers.util;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ers.util.PropertiesParser;

	public class ConnectionFactory {
	
		private final static String URL = PropertiesParser.dbDetails.get("url");
		private final static String USERNAME = PropertiesParser.dbDetails.get("username");
		private final static String PASSWORD = PropertiesParser.dbDetails.get("password");

		private static final Logger loggy = Logger.getLogger(ConnectionFactory.class);
		
		public Connection getConnection() throws SQLException {

			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			loggy.info("Connecting to the database.");
			
			return conn;

		}
	}

