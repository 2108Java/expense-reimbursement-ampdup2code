package com.ers.controller;

import java.util.ArrayList;
import java.util.List;

import com.ers.model.Reimbersment;
import com.ers.service.ReimbursementSer;

import io.javalin.http.Context;

public class ReimbursementController {
	ReimbursementSer sr2;
	public ReimbursementController(ReimbursementSer sr2) {
		this.sr2=sr2;
	}
	
		public void allpastticket(Context ctx) {
		// TODO Auto-generated method stub
		
		System.out.println("YessssssssssssssKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
		List<Reimbersment> rem = new ArrayList<Reimbersment>();
	    rem=(List<Reimbersment>) (sr2.allReimbersment());
	    
	    if(rem == null) {
			ctx.res.setStatus(404);
			ctx.json("no Ticket");
		}else {
			ctx.res.setStatus(200);
			ctx.json(rem);
		}  
		
	 }
	}

