package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.ers.model.Employee;
import com.ers.model.User;


public class DaoImp {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "Passw0rd$";
	private String url = "jdbc:postgresql://" + dbLocation + "/ERS";
	
	
	public int userAutenticate(String username1, String password1) {
		
		
		//System.out.println(url);
	
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


	public boolean registercustomer(Employee newemp,User newuser) {

			boolean success1 = false;
			boolean success2 = false;
			boolean success3 = false;
			//1. Connect to database!
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				String sql = "insert into users(username,password,usertype) VALUES (?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				//System.out.println(ps);
				ps.setString(1, newuser.getUsername());
				ps.setString(2, newuser.getPassword());
				ps.setInt(3, newuser.getUsertypeid());
				
				
				//System.out.println(ps);
				ps.execute();
				
				success1 = true;
				 
							 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				//2. Write a SQL statement String
				String sql = "insert into employee (fname,lname,user_id) values(?,?,(select max(user_id) from users))";
				//String sql = "insert into users(username,password,usertype) values VALUES (?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				//System.out.println(ps);
				ps.setString(1, newemp.getFname());
				ps.setString(2, newemp.getLname());
				
				//System.out.println(ps);
				ps.execute();
				
				success2 = true;
				 
							 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (success1 && success2) {
				success3 =true;
			}
			
			return success3;
		
		
	}


	public Collection<Employee> displayEmployee() {
		
			
		//Transaction[] tran = new Transaction[30];
		Collection <Employee> emp = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			//String sql = "select trans_id,db_account,cr_account,amount,reference,date_created,transaction_type_id from b_transaction";
			String sql = "select employee_id,fname,lname,user_id from employee";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				
				//users1.add(new User("Jules", 20));
						emp.add(new Employee(rs.getInt("employee_id"),rs.getString("fname"),rs.getString("lname"),rs.getInt("user_id")));
						
						
				i++;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return emp;
	
	}


	public int findUserId(String username2, String password2) {
		int result = 0;	
		User  newuser = new User();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			
			String sql = "SELECT user_id,username,password,usertype FROM users where username = ? and password = ?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, username2);
			ps.setString(2, password2);	
//			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			int i =0;
			while(rs.next()) {
						newuser = new User(rs.getInt("user_id"),								
								rs.getString("username"),
								rs.getString("password"),
								rs.getInt("usertype"));
						i++;
			
						}
	
	    result = (int)newuser.getId();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return result;
	}
	

}
