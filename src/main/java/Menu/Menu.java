package Menu;
import java.util.Scanner;

import com.ers.model.User;
import com.ers.service.AuthenticationSer;


public class Menu {
	
	AuthenticationSer sr;
	
	public Menu(AuthenticationSer sr) {
		this.sr = sr;
		
	}


	private void employeeMenu() {

		 System.out.println("\n");
		  System.out.println("Employee Main Menu");
		  System.out.println("\n");
		  System.out.println("1) Add a reimbursement request");
		  System.out.println("2) view past tickets "); 
		  System.out.println("3) Exit");
	}
	
	private void financeMangerMenu() {

		  System.out.println("\n");
		  System.out.println("Finance Manager Main Menu");
		  System.out.println("\n");
		  System.out.println("1) view all the reimbursements");
		  System.out.println("2) filter the requests by the status of the tickets ");
		  System.out.println("3) Exit");
		 
	}
		

	public void display() {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		System.out.println("Welcome to Expense Reimbursement System");
		
		System.out.println("Are you a new user (Y/N)?"+"\n");
		String ch = scanner.nextLine();
		if (ch.equals("Y") || ch.equals("y")) {
			System.out.println("User Registration");
			//System.out.println("First Name");
			//String fname = scanner.nextLine();
			//System.out.println("Last Name");
			//String lname = scanner.nextLine();
			//System.out.println("User Name");
			String username = scanner.nextLine();
			System.out.println("Password");
			String password = scanner.nextLine();
			User newUser = new User(username,password);
     
			if(sr.registerUser(newUser)) {
				System.out.println("\n");
				System.out.println("User Successfully added!");
				System.out.println("\n");
				
			}else {
				System.out.println("not added!");
			}
			
		}
		running = true;
		do {
			System.out.println("----------------Login Menu-------------- ");
			System.out.println("Username");
			String username = scanner.nextLine();
			System.out.println("Password");
			String password = scanner.nextLine();
			System.out.println("--------------------------------------- ");

			
		
			int res = sr.authenticate(username, password);
			

			if (res == 1) {
				
				employeeMenu();
				boolean runningin = true;
				String result = scanner.nextLine();
				switch (result)
				{
				case "1":
					System.out.println("will be implemented");
				case "3":
					//	running =false;
					//	System.out.println("Thanks for using our application ");
						runningin = false;
						//running = false;
						System.out.println("Thanks for using our application << user logged out  ");
						System.out.println("\n");
						break;
				default:
					System.out.println("last Menu");
				}
			   } 
			else if (res == 2) {
				
				boolean runningin = true;
				 do {
					 
					 financeMangerMenu();
					 
					 String result = scanner.nextLine();
						switch (result)
						{
						case "1":
						//	registorcustomeraccout(false,102);
							break;
						case "2":
						//	approveaccount();
							break;
						case "5":
						//	viewaccount();
							break;
						case "4":
						//	displayalltrans();
							break;
						case "3":
						//	running =false;
						//	System.out.println("Thanks for using our application ");
							runningin = false;
							//running = false;
							System.out.println("Thanks for using our application << user logged out  ");
							System.out.println("\n");
							break;
						default:
							System.out.println("last Menu");
							
						}
				 }while (runningin);
				
						} 
		 
			else 
				System.out.println("Invalid Username or Password ");
			
		}while (running);
		
		}
	
	}

