package com.ers.controller;

import java.io.IOException;

import com.ers.service.AuthenticationSer;

import io.javalin.http.Context;

public class AuthenticateController {
	
	AuthenticationSer sr;
	
	public AuthenticateController(AuthenticationSer service) {
		this.sr=service;
	}
	public int authenticate(Context ctx) {
		
				
		System.out.println(ctx.formParam("username"));
		System.out.println(ctx.formParam("password"));
		String page = "";
		
		String username = ctx.formParam("username");
		String password =ctx.formParam("password");
		int res=sr.authenticate(username, password);
		System.out.println("The Selected User      "+res);
		return res;
 }
}