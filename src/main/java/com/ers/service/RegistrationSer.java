package com.ers.service;




import java.util.Collection;

import com.ers.dao.DaoImp;
import com.ers.model.Employee;
import com.ers.model.User;

public class RegistrationSer {
		DaoImp database;
		public RegistrationSer(DaoImp database2) {
			this.database = database2;
		}
		public boolean employeeRegistor(Employee newemp,User newuser) {
		// TODO Auto-generated method stub
		return database.registeremployee(newemp,newuser);
	}
		public Collection <Employee> displayEmployee() {
			// TODO Auto-generated method stub
			return database.displayEmployee();
		}
		public int findEmpid(int userid) {
			
			return database.findEmpid(userid);
		}
		
	
	
}
