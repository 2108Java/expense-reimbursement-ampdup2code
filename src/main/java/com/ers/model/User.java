package com.ers.model;


public class User {
	
	
	private int id; 
	private String username;
	private String password;
	private int usertypeid;
	
	
	
	public User() {
		
		this("placeholder","placeholder");
		
	}
	
	public User(String username, String password) {
		
		this(-1,username,password,0);
		
		
	}

	public User(int id, String username, String password,int usertypeid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertypeid = usertypeid;
	}
	
	
	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

}