package com.revature.controller;

//import javax.servlet.ServletRequest;

import io.javalin.Javalin;

public class RequestHandler {
	
	static AuthenticateController authenticateController;
	public static void setUpEndpoints(Javalin app) {
		
		//AuthenticateController authenticateController = new AuthenticateController();
		app.get("/login", ctx -> ctx.redirect(authenticateController.authenticate(ctx)));
		app.get("/", ctx ->
		ctx.redirect("Login.html"));
		

	
	}

	public RequestHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RequestHandler(AuthenticateController serctrl) {
		// TODO Auto-generated constructor stub
		this.authenticateController=serctrl;
	}

}
