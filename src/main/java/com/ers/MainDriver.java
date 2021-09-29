package com.ers;

import com.ers.dao.DaoImp;
import com.ers.service.AuthenticationSer;

import Menu.Menu;

public class MainDriver {
	
	public static void main(String[] args) {

		
		DaoImp database = new DaoImp();
		
		AuthenticationSer service = new AuthenticationSer(database);
		
		//BankRegistrationService service1 =new BankRegistrationService(database);
		
		//TransactionProcessindServ service2 =new TransactionProcessindServ(database);
		
		//Menu mainMenu = new Menu(service,service1,service2);
		
		Menu mainMenu = new Menu(service);
		
		mainMenu.display();
		
	}

}
