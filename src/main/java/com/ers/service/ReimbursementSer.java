package com.ers.service;

import java.util.Collection;

import com.ers.dao.DaoImp;
import com.ers.model.Reimbersment;

public class ReimbursementSer {
	
	DaoImp database;
	public ReimbursementSer(DaoImp database2) {
		this.database = database2;
	}
	public boolean addReimbersment(Reimbersment res) {
		
		return database.addReimbersment(res);
	}
	public Collection <Reimbersment> displayReimbersment(int empid) {
		// TODO Auto-generated method stub
		return database.displayReimbersment(empid);
	}
	

}
