package com.ers;


import com.ers.controller.AuthenticateController;
import com.ers.controller.RequestHandler;
import com.ers.dao.DaoImp;
import com.ers.service.AuthenticationSer;

import io.javalin.Javalin;

public class MainDriver {
	
	public static void main(String[] args) {
		
		
		Javalin app = Javalin.create(config -> config.addStaticFiles(
				staticFiles ->
				{
					staticFiles.directory = "/public";
				}
				)).start(7000);

		
		DaoImp database = new DaoImp();
		AuthenticationSer service = new AuthenticationSer(database);
		AuthenticateController ctrl = new AuthenticateController(service);
		RequestHandler.setUpEndpoints(app,ctrl);
		
	}

}
