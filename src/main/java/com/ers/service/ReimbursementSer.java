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
		
		return database.displayReimbersment(empid);
	}
	public Collection<Reimbersment> allReimbersment() {
		
		return database.allReimbersment();
	}
	public Collection<Reimbersment> viewReimbursementsByStatus(int approvedid) {
		return database.viewReimbursementsByStatus(approvedid);
	}
	
	public boolean ApproveorRejectReimbursements(int rid,int status,int empid) {
		return database.ApproveorRejectReimbursements(rid,status,empid);
		
	}
	

}
