package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ers.model.Reimbersment;
import com.ers.service.AuthenticationSer;
import com.ers.service.RegistrationSer;
import com.ers.service.ReimbursementSer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;

public class AuthenticateController {
	
	AuthenticationSer sr;
	RegistrationSer sr1;
	ReimbursementSer sr2;
	public AuthenticateController(AuthenticationSer service,RegistrationSer service1,ReimbursementSer service2) {
		this.sr=service;
		this.sr1=service1;
		this.sr2=service2;
	}
	
	String username="";
	String password="";
	public int authenticate(Context ctx) {
		
				
		System.out.println(ctx.formParam("username"));
		System.out.println(ctx.formParam("password"));
		String page = "";
		
		username = ctx.formParam("username");
		System.out.println(username);
		password =ctx.formParam("password");
		System.out.println(password);
		int res=sr.authenticate(username, password);
		System.out.println("The Selected User      "+res);
		return res;
 }
	public int finduser(String username,String password) {
		
		return sr.findUserId(username,password);
	}
	
	
	public void pastticket(Context ctx) {
		// TODO Auto-generated method stub
		
		int userid = sr.findUserId(username,password);
		System.out.println("---------"+userid);
		int empid = sr1.findEmpid(userid);
		System.out.println("----------"+empid);
		ctx.res.setStatus(200);
		List<Reimbersment> rem = new ArrayList<Reimbersment>();
	    rem=(List<Reimbersment>) (sr2.displayReimbersment(userid));
		
	    if(rem == null) {
			ctx.res.setStatus(404);
			ctx.json("no Ticket");
		}else {
			ctx.res.setStatus(200);
			ctx.json(rem);
		}  
		
	    System.out.println("-------------------Reimbersment Tickets "+empid+"--------------------");

		 for (Reimbersment rem1 : rem) {
			 String typeid ="";
			 if (rem1.getRembtypeid()==1)
			 {
				 typeid="LODGING"; 
			 }else if (rem1.getRembtypeid()==2)
			 {
				 typeid="Travel";
			 }else if (rem1.getRembtypeid()==3)
			 {
				 typeid="Food";
			 }
			 else {
				 typeid="Other";
			 }
			 String Approveid ="";
			 if (rem1.getApprovedid()==1)
			 {
				 Approveid="Approved"; 
			 }else if (rem1.getApprovedid()==2)
			 {
				 Approveid="Rejected";
			 }
			 else  
			 {
				 Approveid="Pending";
			 }
			  
			 System.out.println("\n");
			 System.out.println("Reimbersment Id :"+ rem1.getRembid());
			 System.out.println("Employee Id :"+rem1.getEmpid());
			 System.out.println("Approved_id :"+Approveid);
			 System.out.println("Reimbersment Amount :"+rem1.getRemamount());
			 System.out.println("Date created :"+rem1.getCreatedtime());
			 System.out.println("Description :"+rem1.getDescription());
			 System.out.println("Type Id :"+ typeid);
	    
	    
		 }
	 }
	}
		
