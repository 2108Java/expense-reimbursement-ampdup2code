package Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.ers.model.Employee;
import com.ers.model.Reimbersment;
import com.ers.model.User;
import com.ers.service.AuthenticationSer;
import com.ers.service.RegistrationSer;
import com.ers.service.ReimbursementSer;


public class Menu {
	
	AuthenticationSer sr;
	RegistrationSer sr1;
	ReimbursementSer sr2;
	
	public Menu(AuthenticationSer sr) {
		this.sr = sr;
		
	}


	public Menu(AuthenticationSer sr, RegistrationSer sr1,ReimbursementSer sr2) {
		this.sr = sr;
		this.sr1 = sr1;
		this.sr2 = sr2;
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
    	if (userid != 0) {
    		System.out.println("!!!!!!!!!!!"+userid);
    		int empid = sr1.findEmpid(userid);
    			if (empid != 0) {
	    			
			    	System.out.println("--------------------- Reimbursement Registration-------------------------");
					Scanner sc = new Scanner(System.in);
					System.out.println("Reimbursement Description");
					String desc = sc.nextLine();
					System.out.println("Reimbursement Amount");
					Double ramount = sc.nextDouble();
					System.out.println("Reimburslodging :Lodging:1,Travel:2,Food:3 or Other:4");
					int rebtype = sc.nextInt();
					int approvedid=3;
					Reimbersment rem =new Reimbersment(empid,ramount,desc,rebtype,approvedid);
					boolean res=sr2.addReimbersment(rem);
					if(res) {
						System.out.println("Reimbursement Successfully Registered");
					} else {
						System.out.println("Reimbursement Not Registered");
					}
					System.out.println("Employee Not Register Reimbursement");		
    		}
    		System.out.println("User Not Found");
    	}
    		
    }
    
    private void viewpastticket(String username,String password) {
    	int userid = sr.findUserId(username,password);
    	int empid = sr1.findEmpid(userid);
    	
    	
    	Collection <Reimbersment> rem = new ArrayList<Reimbersment>();
    	
		rem = sr2.displayReimbersment(empid);
		System.out.println("-------------------view Reimbersment  "+empid+"--------------------");

		 for (Reimbersment rem1 : rem) {
			 String typeid ="";
			 if (rem1.getRembtypeid()==1)
			 {
				 typeid="LODGING"; 
			 }else if (rem1.getRembtypeid()==1)
			 {
				 typeid="Travel";
			 }else if (rem1.getRembtypeid()==1)
			 {
				 typeid="Food";
			 }
			 else {
				 typeid="Other";
			 }
			 String Approveid ="";
			 if (rem1.getApprovedid()==1)
			 {
				 Approveid="Approved"; 
			 }else if (rem1.getApprovedid()==2)
			 {
				 Approveid="Rejected";
			 }
			 else  
			 {
				 Approveid="Pending";
			 }
			 
			 
			 
			 
			 
			 
			 System.out.println("\n");
			 System.out.println("Reimbersment Id :"+ rem1.getRembid());
			 System.out.println("Employee Id :"+rem1.getEmpid());
			 System.out.println("approved_id :"+Approveid);
			 System.out.println("Reimbersment Amount :"+rem1.getRemamount());
			// System.out.println("Fm Id :"+rem1.getFmid());
			 System.out.println("Date created :"+rem1.getCreatedtime());
			 System.out.println("Description :"+rem1.getDescription());
			 System.out.println("Type Id :"+ typeid);
			 
			 
			 
			 
			 
		 }
		 System.out.println("----------------------------------------------------------");	
    	
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
				boolean runningin = true;
				 do {
					employeeMenu();
					String result = scanner.nextLine();
					switch (result)
						{
						case "1":
							addReimbursement(username,password);
							break;
						case "2":
							viewpastticket(username,password);
							System.out.println("to be implemented");
						case "3":
							runningin = false;
							System.out.println("Thanks for using our application << user logged out  ");
							System.out.println("\n");
							break;
						default:
							System.out.println("Wrong menu selection");
						}
				 } while (runningin);
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

