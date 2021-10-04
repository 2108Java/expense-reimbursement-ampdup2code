package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.ers.model.Employee;
import com.ers.model.Reimbersment;
import com.ers.model.User;


public class DaoImp {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "Passw0rd$";
	private String url = "jdbc:postgresql://" + dbLocation + "/ERS";
	
	
	public int userAutenticate(String username1, String password1) {
		
	
		int result = 0;	
			User  newuser = new User();
			try(Connection connection = DriverManager.getConnection(url, username, password)){
			
				
				String sql = "SELECT * FROM users where username = ? and password = ?";
					
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, username1);
				ps.setString(2, password1);	
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
				e.printStackTrace();
			}
				
			return result;
		}


	public boolean registeremployee(Employee newemp,User newuser) {

			boolean success1 = false;
			boolean success2 = false;
			boolean success3 = false;
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
		
				String sql = "insert into users(username,password,usertype) VALUES (?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, newuser.getUsername());
				ps.setString(2, newuser.getPassword());
				ps.setInt(3, newuser.getUsertypeid());
				
				
				
				ps.execute();
				
				success1 = true;
				 
							 
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				
				String sql = "insert into employee (fname,lname,user_id) values(?,?,(select max(user_id) from users))";
				
				
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setString(1, newemp.getFname());
				ps.setString(2, newemp.getLname());
				
	
				ps.execute();
				
				success2 = true;
				 
							 
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			if (success1 && success2) {
				success3 =true;
			}
			int userid=newuser.getUsertypeid();
			
			if (userid==2)
				{
			
				
		
				try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				
				String sql = "insert into finance_manager (fm_id,fname,lname,user_id) values((select max(employee_id) from employee),?,?,?)";
				
				
				PreparedStatement ps = connection.prepareStatement(sql);
		
				ps.setString(1, newemp.getFname());
				ps.setString(2, newemp.getLname());
				ps.setInt(3, userid);
				
				
				ps.execute();
			
		
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
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
			
			e.printStackTrace();
		}
			
		return result;
	}
	

	
	public int findEmpid(int userid) {
		int result = 0;	
		 Employee newemp = new Employee();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			
			String sql = "select employee_id,fname,lname,user_id from employee where user_id=?";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, userid);

			ResultSet rs = ps.executeQuery();
			int i =0;
			while(rs.next()) {
						newemp = new Employee(rs.getInt("employee_id"),								
								rs.getString("fname"),
								rs.getString("lname"),
								rs.getInt("user_id"));
						i++;
			
						}
	
	    result = (int)newemp.getUser_id();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return result;
	}
		
	
    public boolean addReimbersment(Reimbersment remb) {
    	
    	boolean success = false;
    	
    	try(Connection connection = DriverManager.getConnection(url,username,password)){
			
			String sql = "insert into reimbursment (employee_id,remb_amount,type_id,description,approved_id) values (?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, remb.getEmpid());
			ps.setDouble(2, remb.getRemamount());
			ps.setInt(3, remb.getRembtypeid());
			ps.setString(4, remb.getDescription());
			ps.setInt(5, remb.getApprovedid());

			ps.execute();
			success = true;				 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return success;
    }


	public Collection<Reimbersment> displayReimbersment(int empid) {
		
		Collection <Reimbersment> rem = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String sql = "select remb_id ,employee_id ,approved_id ,remb_amount,fm_id,time_stamp,description,type_id from reimbursment where employee_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				
		
						rem.add(new Reimbersment(rs.getInt("remb_id"),
								rs.getInt("employee_id"),
								rs.getInt("approved_id"),
								rs.getDouble("remb_amount"),
								rs.getInt("fm_id"),
								rs.getDate("time_stamp"),
								rs.getString("description"),
								rs.getInt("type_id")));
						
						
				i++;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rem;
		
	}


	public Collection<Reimbersment> allReimbersment() {
		Collection <Reimbersment> rem = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String sql = "select remb_id ,employee_id ,approved_id ,remb_amount,fm_id,time_stamp,description,type_id from reimbursment";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
						rem.add(new Reimbersment(rs.getInt("remb_id"),
								rs.getInt("employee_id"),
								rs.getInt("approved_id"),
								rs.getDouble("remb_amount"),
								rs.getInt("fm_id"),
								rs.getDate("time_stamp"),
								rs.getString("description"),
								rs.getInt("type_id")));
							
				i++;
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return rem;
	}


	public Collection<Reimbersment> viewReimbursementsByStatus(int approvedid) {
		Collection <Reimbersment> rem = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String sql = "select remb_id ,employee_id ,approved_id ,remb_amount,fm_id,time_stamp,description,type_id from reimbursment where approved_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, approvedid);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
						rem.add(new Reimbersment(rs.getInt("remb_id"),
								rs.getInt("employee_id"),
								rs.getInt("approved_id"),
								rs.getDouble("remb_amount"),
								rs.getInt("fm_id"),
								rs.getDate("time_stamp"),
								rs.getString("description"),
								rs.getInt("type_id")));
							
				i++;
				
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
		return rem;
	}


	public boolean ApproveorRejectReimbursements(int rid, int status,int empid) {
		
		boolean success = false;
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			
			String sql = "update reimbursment set approved_id = ?,fm_id = ? where remb_id = ? ";
				
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, status);
			ps.setInt(2, empid);
			ps.setInt(3, rid);

		    ps.execute();
			success = true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		
	      }
		
		return success;
		}
	
	}
