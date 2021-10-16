package com.ers;


import com.ers.controller.AuthenticateController;
import com.ers.controller.ReimbursementController;
import com.ers.controller.RequestHandler;
import com.ers.dao.DaoImp;
import com.ers.service.AuthenticationSer;
import com.ers.service.RegistrationSer;
import com.ers.service.ReimbursementSer;

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
		RegistrationSer service1 = new RegistrationSer(database) ;
		ReimbursementSer service2 = new ReimbursementSer(database);
		ReimbursementController rem = new ReimbursementController(service2);
		AuthenticateController ctrl = new AuthenticateController(service,service1,service2);
		RequestHandler.setUpEndpoints(app,ctrl,rem);
		
	}

}
