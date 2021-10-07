package com.ers.controller;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RequestHandler {
	
	
	public static boolean checkAccess(Context ctx) {
		if(ctx.sessionAttribute("access") != null //checking if session exists
				&& (Boolean) ctx.sessionAttribute("access") == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void setUpEndpoints(Javalin app,AuthenticateController ctrl) {
		

	//	final String LOGIN = "/Login";

		app.get("/", 
				ctx ->ctx.req.getRequestDispatcher("/Login.html").forward(ctx.req, ctx.res));
		
		//app.get("/Login", ctx -> ctx.req.getRequestDispatcher("/Login.html").forward(ctx.req, ctx.res));
		app.post("/Login", ctx -> 
		{
			if(ctrl.authenticate(ctx)==1) {
				ctx.res.sendRedirect("/Menu");
			}
			//ctx.req.getRequestDispatcher("Menu.html").forward(ctx.req, ctx.res);
			else if(ctrl.authenticate(ctx)==2) {
				//System.out.println("dddddddddddddddddddddddd");
				ctx.res.sendRedirect("/FMenu");
				//ctx.req.getRequestDispatcher("Menu.html").forward(ctx.req, ctx.res);	
			
			}else {
				ctx.res.sendRedirect("/FailedLogin");
			}
		
		
		});
		
		app.get("/Menu", 
				ctx -> ctx.req.getRequestDispatcher("/Menu.html").forward(ctx.req, ctx.res));
		app.get("/FailedLogin", 
				ctx -> ctx.req.getRequestDispatcher("/FailedLogin.html").forward(ctx.req, ctx.res));
		app.get("/FMenu", 
				ctx -> ctx.req.getRequestDispatcher("/FMenu.html").forward(ctx.req, ctx.res));
		app.post("/FailedLogin.html", ctx -> 
		{
				
				if(ctrl.authenticate(ctx)==1) {
					ctx.res.sendRedirect("/Menu");
				}
				//ctx.req.getRequestDispatcher("Menu.html").forward(ctx.req, ctx.res);
				else if(ctrl.authenticate(ctx)==2) {
					//System.out.println("dddddddddddddddddddddddd");
					ctx.res.sendRedirect("/FMenu");
					//ctx.req.getRequestDispatcher("Menu.html").forward(ctx.req, ctx.res);	
				
				}else {
					ctx.res.sendRedirect("/FailedLogin");
				}
		
		
		});
		}

}
