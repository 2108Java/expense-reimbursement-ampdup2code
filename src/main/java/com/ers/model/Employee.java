package com.ers.model;

public class Employee {
	
	private int employee_id;
	private String fname;
	private String lname;
	private int user_id;
	
	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public Employee(int employee_id, String fname, String lname, int user_id) {
		super();
		this.employee_id = employee_id;
		this.fname = fname;
		this.lname = lname;
		this.user_id = user_id;
	}
	
	
	public Employee(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}


	public Employee() {
		super();
	}


	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}


	
	

}
