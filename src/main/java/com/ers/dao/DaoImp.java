package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.model.User;


public class DaoImp {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "Passw0rd$";
	private String url = "jdbc:postgresql://" + dbLocation + "/ERS";
	
	
	public int userAutenticate(String username1, String password1) {
		
		
		System.out.println(url);
	
		int result = 0;	
			User  newuser = new User();
			try(Connection connection = DriverManager.getConnection(url, username, password)){
			
				
				String sql = "SELECT * FROM users where username = ? and password = ?";
					
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, username1);
				ps.setString(2, password1);	
//				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				int i =0;
				while(rs.next()) {
							newuser = new User(rs.getInt("user_id"),								
									rs.getString("username"),
									rs.getString("password"),
									rs.getInt("usertype"));
							i++;
				
							}
		
		result = (int)newuser.getUsertypeid();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return result;
		}
	

}
