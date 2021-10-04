package com.ers.model;

import java.sql.Date;

public class Reimbersment {
	
	private int rembid;
	private int empid;
	private int approvedid;
	private double remamount;
	private int fmid;
	private int rembtypeid;
	private Date createdtime;
	private String description;
	
	
	
	
	
	
	
	public Reimbersment(int rembid, int empid, int approvedid, double remamount, int fmid, Date createdtime,
			String description,int rembtypeid) {
		super();
		this.rembid = rembid;
		this.empid = empid;
		this.approvedid = approvedid;
		this.remamount = remamount;
		this.fmid = fmid;
		this.createdtime = createdtime;
		this.rembtypeid = rembtypeid;
		this.description = description;
	}
	public Reimbersment(int empid, double remamount, String description,int rembtypeid,int approvedid) {
		super();
		this.empid = empid;
		this.remamount = remamount;
		this.description = description;
		this.rembtypeid=rembtypeid;
		this.approvedid=approvedid;
	}
	public int getRembid() {
		return rembid;
	}
	public void setRembid(int rembid) {
		this.rembid = rembid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getApprovedid() {
		return approvedid;
	}
	public void setApprovedid(int approvedid) {
		this.approvedid = approvedid;
	}
	public double getRemamount() {
		return remamount;
	}
	public void setRemamount(double remamount) {
		this.remamount = remamount;
	}
	public int getFmid() {
		return fmid;
	}
	public void setFmid(int fmid) {
		this.fmid = fmid;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRembtypeid() {
		return rembtypeid;
	}
	public void setRembtypeid(int rembtypeid) {
		this.rembtypeid = rembtypeid;
	}
	
	 
	

}
