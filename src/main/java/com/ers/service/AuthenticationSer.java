package com.ers.service;



import com.ers.dao.DaoImp;
import com.ers.model.User;

public class AuthenticationSer {
	
	DaoImp database;
	
	public AuthenticationSer(DaoImp database) {
		this.database = database;
	}
	
	

	public boolean registerUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public int authenticate(String username, String password) { //verify that they are the user
		
		return database.userAutenticate(username,password);
	}
	
	
}
