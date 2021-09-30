package Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.ers.model.Employee;
import com.ers.model.User;
import com.ers.service.AuthenticationSer;
import com.ers.service.RegistrationSer;


public class Menu {
	
	AuthenticationSer sr;
	RegistrationSer sr1;
	
	public Menu(AuthenticationSer sr) {
		this.sr = sr;
		
	}


	public Menu(AuthenticationSer sr, RegistrationSer sr1) {
		this.sr = sr;
		this.sr1 = sr1;
		
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
	private void hrMenu() {

		  System.out.println("\n");
		  System.out.println("Human Resource Main Menu");
		  System.out.println("\n");
		  System.out.println("1) Register an Employee");
		  System.out.println("2) View All Employee ");
		  System.out.println("3) Exit");
		 
	}
		
    private void registoranEmployee() {
    	
			System.out.println(" Employee Registration");
			Scanner sc = new Scanner(System.in);
			System.out.println("First Name");
			String fname = sc.nextLine();
			System.out.println("Last Name");
			String lname = sc.nextLine();
			System.out.println("Email Address");
			String username = sc.nextLine();
			System.out.println("Password");
			String pass = sc.nextLine();
			System.out.println("user type: Empoloyee 1,Finance Mgr 2, HR user 3");
			int usertype = sc.nextInt();
	
		    Employee newemp = new Employee(fname,lname);
		    User newuser =new User(username,pass,usertype);
		    
		    boolean res=sr1.employeeRegistor(newemp,newuser);
		//    boolean res1=sr1.userRegistor(newuser);
		    if (res) {
		    	System.out.println("Employee Sucessfuly Registered");
		    }else {
		    	System.out.println("Employee Not Registered");
		    }
    
    }
    
    private void displayEmployee() {
    		
    	Collection <Employee> emp = new ArrayList<Employee>();
    	
		emp = sr1.displayEmployee();
		System.out.println("---------------------All Employee List --------------------");

		 for (Employee emp1 : emp) {
			 System.out.println("\n");
			 System.out.println("Employee Id :"+ emp1.getEmployee_id());
			 System.out.println("Employee Fname :"+emp1.getFname());
			 System.out.println("Employee Lname :"+emp1.getLname());
			 System.out.println("User Id :"+emp1.getUser_id());
			 
		 }
		 System.out.println("----------------------------------------------------------");
    }
    
    private void addReimbursement(String username,String password) {
    	
    	
    	
    	int userid = sr.findUserId(username,password);
    	System.out.println("@@@@@@@@@@@@"+userid);
    	
    	System.out.println(" Reimbursement Registration");
		Scanner sc = new Scanner(System.in);
		System.out.println("Reimbursement Description");
		String desc = sc.nextLine();
		System.out.println("Reimbursement Amount");
		Double amount = sc.nextDouble();
//		System.out.println("Email Address");
//		String username = sc.nextLine();
//		System.out.println("Password");
//		String pass = sc.nextLine();
//		System.out.println("user type: Empoloyee 1,Finance Mgr 2, HR user 3");
//		int usertype = sc.nextInt();
//
//	    Employee newemp = new Employee(fname,lname);
//	    User newuser =new User(username,pass,usertype);
//	    
//	    boolean res=sr1.employeeRegistor(newemp,newuser);
//	//    boolean res1=sr1.userRegistor(newuser);
//	    if (res) {
//	    	System.out.println("Employee Sucessfuly Registered");
//	    }else {
//	    	System.out.println("Employee Not Registered");
//	    }
//    	
//    	
    	
    	
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
					addReimbursement(username,password);
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
							registoranEmployee();
							break;
						case "2":
						// viewEmployee();
							break;
						case "3":
							runningin = false;
							System.out.println("Thanks for using our application << user logged out  ");
							System.out.println("\n");
							break;
						default:
							System.out.println("Wrong Menu selection");
							
						}
				 }while (runningin);
			}
			else if (res == 3) {
						
						boolean runningin = true;
						 do {
							 
							 hrMenu();
							 
							 String result = scanner.nextLine();
								switch (result)
								{
								case "1":
									registoranEmployee();
									break;
								case "2":
									displayEmployee();
									break;
								case "3":
									runningin = false;
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

