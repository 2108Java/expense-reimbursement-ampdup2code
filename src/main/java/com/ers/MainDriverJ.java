package com.ers;
//package com.ers;
//
//
//import com.ers.dao.DaoImp;
//import com.ers.service.AuthenticationSer;
//import com.revature.controller.AuthenticateController;
//import com.revature.controller.RequestHandler;
//
//import io.javalin.Javalin;
//
//public class MainDriver {
//	
//	public static void main(String[] args) {
//		
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(8001);
//		
//		
//		
//		DaoImp database = new DaoImp();
//		
//		AuthenticationSer service = new AuthenticationSer(database);
//		
//		AuthenticateController serctrl = new AuthenticateController(service);
//		
//		RequestHandler rq = new RequestHandler(serctrl);
//		
//		rq.setUpEndpoints(app);
//		
//	}
//
//}
