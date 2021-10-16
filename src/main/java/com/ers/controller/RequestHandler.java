package com.ers.controller;


import io.javalin.Javalin;
import io.javalin.http.Context;
//import org.apache.log4j.Logger;

import com.ers.controller.RequestHandler;
public class RequestHandler {
	
	//private static final Logger loggy = Logger.getLogger(RequestHandler.class);
	public static boolean checkAccess(Context ctx) {
		if(ctx.sessionAttribute("access") != null //checking if session exists
				&& (Boolean) ctx.sessionAttribute("access") == true) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public static void setUpEndpoints(Javalin app,AuthenticateController ctrl,ReimbursementController rem) {
		



		app.get("/", 
				ctx ->ctx.req.getRequestDispatcher("/login.html").forward(ctx.req, ctx.res));
		
		
//		app.get("/LOGIN", 
//				ctx ->ctx.req.getRequestDispatcher("/login.html").forward(ctx.req, ctx.res));
//		
		
		
		
		app.post("/LOGIN", ctx -> 
		{
			if(ctrl.authenticate(ctx)==1) {
			//	loggy.info("User logged in as an employee.");
				ctx.res.sendRedirect("/EMENU");
			}
	
			else if(ctrl.authenticate(ctx)==2) {
			//	loggy.info("User logger in as a finance manager.");
				ctx.res.sendRedirect("/FMENU");
				
			}else {
			//	loggy.warn("User failed to login.");
				ctx.res.sendRedirect("/FAILEDLOGIN");
			}
		
		
		});
		
		app.get("/EMENU", 
				ctx -> ctx.req.getRequestDispatcher("/employee-menu.html").forward(ctx.req, ctx.res));
		
		app.get("/FMENU", 
				ctx -> ctx.req.getRequestDispatcher("/fmanager-menu.html").forward(ctx.req, ctx.res));
		
		app.get("/FAILEDLOGIN", 
				ctx -> ctx.req.getRequestDispatcher("/login-fail.html").forward(ctx.req, ctx.res));
		
			
		
		app.get("/VIEWPASTTICKETFR",
				ctx -> ctx.res.sendRedirect("/VIEWPASTTICKETDETAIL"));
			//ctx.req.getRequestDispatcher("/employee-view-past-tickets.html").forward(ctx.req, ctx.res);


		app.get("/VIEWPASTTICKETDETAIL",ctx -> {
			ctx.req.getRequestDispatcher("/employee-view-past-tickets.html").forward(ctx.req, ctx.res);
		});
		
		
		
		app.get("/VIEWPASTTICKETFILL",ctx -> {
			ctrl.pastticket(ctx);
		});
		
	
		
		app.get("/VIEWPASTTICKETFRALL",
				ctx -> ctx.res.sendRedirect("/VIEWPASTTICKETDETAILALL"));
			//ctx.req.getRequestDispatcher("/employee-view-past-tickets.html").forward(ctx.req, ctx.res);


		app.get("/VIEWPASTTICKETDETAILALL",ctx -> {
			ctx.req.getRequestDispatcher("/finance-view-past-tickets.html").forward(ctx.req, ctx.res);
		});
		
		
		
		app.get("/VIEWPASTTICKETFILLALL",ctx -> {
			rem.allpastticket(ctx);
		});
		
		
		
		
		
		
		
		
		app.post("/FAILEDLOGIN", ctx -> 
		{
				
			if(ctrl.authenticate(ctx)==1) {
				//loggy.info("User logged in as an employee.");
				ctx.res.sendRedirect("/EMENU");
			}
	
			else if(ctrl.authenticate(ctx)==2) {
				//loggy.info("User logger in as a finance manager.");
				ctx.res.sendRedirect("/FMENU");
				
			}else {
				//loggy.warn("User failed to login.");
				ctx.res.sendRedirect("/FAILEDLOGIN");
			}
		
		});
		}
	

	

}
