package project.main;

import java.util.Scanner;
import project.beans.Account;
import project.beans.User;
import project.dao.AccountDAO;
import project.dao.AccountDAOImpl;
import project.dao.UserDAO;
import project.dao.UserDAOImpl;
import project.exceptions.BankException;
import project.exceptions.LoginException;

public class Driver {
	

	public static void main(String[] args) throws LoginException, BankException {
		int home = 0;
		Scanner scan = new Scanner(System.in);
		while(home != 3) {
			System.out.println("Welcome to JDBC Bank!");
			System.out.println("Enter one of the following values: ");
			System.out.println("0: If you want to login to your account.");
			System.out.println("1: If you are a new user and you want to register.");
			System.out.println("2: If you are a superuser trying to access your other priviledges.");
			System.out.println("3: To exit the application.");
	        String input;
	        input = scan.nextLine();
	        if(!(input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3"))) {
	        	System.out.println("Invalid entry. You must enter one of the numbers you were prompted to enter.");
	        	System.out.println("Hit enter to get see your options again ");
	        	scan.nextLine();
	        	
	        } else {
		        home = Integer.parseInt(input);
		        if(input.equals("1")) {
		        	System.out.println("Enter a username. Username must be less then 21 characters and can use any combination"
		        			+ " of characters");
		        	String uName = scan.nextLine();
		        	UserDAO r = new UserDAOImpl();
		        	int wrong = -1;
		        	while (wrong == -1) {
			        	try {
				        	r.uniqueUsername(uName);
				        	wrong = 0;
			        	} catch(LoginException e) {
			        		System.out.println(e);
			        		System.out.println("Enter a username. Username must be less then 21 characters and can use any combination"
				        			+ " of characters");
				        	uName = scan.nextLine();
			        	}
			        	
		        	}
		        	System.out.println("Enter a password. Password must be less then 21 characters and can use any combination"
		        			+ " of characters");
		        	String pass = scan.nextLine();
		        	System.out.println("Enter your first Name");
		        	String fName = scan.nextLine();
		        	System.out.println("Enter your last name");
		        	String lName = scan.nextLine();
		        	System.out.println("Enter your eMail");
		        	String eMail = scan.nextLine();
		            User a = new User(10, fName, lName, uName, pass, eMail, 2);
		            r.createUser(a);
		            System.out.println("Registered Successefully! Hit enter to return to the main page");
		            String next = scan.nextLine();
		            
		        } else if(input.equals("0")) {
		        	System.out.println("Enter your username");
		        	String uName = scan.nextLine();
		        	UserDAO r = new UserDAOImpl();
		        	int wrong = -1;
		        	while (wrong == -1) {
			        	try {
			        		r.checkUsername(uName);
				        	wrong = 0;
			        	} catch(LoginException e) {
			        		System.out.println(e);
			        		System.out.println("Enter your username");
				        	uName = scan.nextLine();
			        	}
			        	
		        	}
		        	
		        	System.out.println("Enter your password");
		        	String pass = scan.nextLine();
		        	wrong = -1;
		        	while (wrong == -1) {
			        	try {
			        		r.checkPass(uName, pass);
				        	wrong = 0;
			        	} catch(LoginException e) {
			        		System.out.println(e);
			        		System.out.println("Enter your username");
				        	pass = scan.nextLine();
			        	}
			        	
		        	}
		        	
		        	System.out.println("You have successfuly logged in.");
		        	int logged = -1;
		        	while(logged != 5) {
			        	System.out.println("Enter one of the following values: ");
			        	System.out.println("0: To view all existing accounts.");
			        	System.out.println("1: To create a new account.");
			        	System.out.println("2: To delete an account.");
			        	System.out.println("3: To make a deposit.");
			        	System.out.println("4: To make a withdrawal.");
			        	System.out.println("5: To logout.");
			        	String input2 = scan.nextLine();
			        	if(!(input2.equals("0") || input2.equals("1") || input2.equals("2") || input2.equals("3") || input2.equals("4") || input2.equals("5"))) {
			        		System.out.println("Invalid entry. You must enter one of the numbers you were prompted to enter.");
				        	System.out.println("Hit enter to get see your options again ");
				        	scan.nextLine();
			        	} else {
				        	logged = Integer.parseInt(input2);
				        	if(input2.equals("0")) {
				        		User b = r.getUserByName(uName);
				        		AccountDAO d = new AccountDAOImpl();
				        		for (Account c : d.getAccountsByID(b.getId())) {
				        			System.out.println("Account: " + c.getAccountNum() + " Balance: " + c.getBalance());
				        		}
				        		System.out.println("Hit enter to go back to the main menu");
			        			String next = scan.nextLine();
				        		
				        	} else if(input2.equals("1")) {
				        		AccountDAO create = new AccountDAOImpl();
				        		User b = r.getUserByName(uName);
				        		Account g = new Account(10, 10, 0.0, b.getId());
				        		create.createAccount(g);
				        		System.out.println("New Account created. Hit enter to go back to the main menu");
				        		scan.nextLine();
				        		
				        	} else if(input2.equals("2")) {
				        		AccountDAO d = new AccountDAOImpl();
				        		User b = r.getUserByName(uName);
				        		for (Account c : d.getAccountsByID(b.getId())) {
				        			System.out.println("Account: " + c.getAccountNum() + " Balance: " + c.getBalance());
				        		}
				        		
				        		System.out.println("Which account would you like to delete? Enter the account number");
				        		String deleteAcc = scan.nextLine();
				        		int del = Integer.parseInt(deleteAcc);
				        		double canDel = 0;
				        		for (Account m : d.getAccountsByID(b.getId())) {
				        			if(m.getAccountNum() == del) {
				        				canDel = m.getBalance();
				        			}
				        		}
				        		wrong = -1;
					        	while (wrong == -1) {
						        	try {
						        		d.deleteAccount(del, canDel);
							        	wrong = 0;
							        	System.out.println("Account successfully deleted. Hit enter to go back to the main menu");
						        	} catch(BankException e) {
						        		System.out.println(e);
						        		String shouldW = scan.nextLine();
						        		if(shouldW.equals("1")) {
						        			canDel = - canDel;
						        			canDel = d.transacation(del, canDel);
						        		} else {
						        			wrong = 0;
						        			System.out.println("Hit enter to return to the main menu");
						        			scan.hasNextLine();
						        		}
						        	}
						        	
					        	}
					        	
				        		scan.nextLine();
				        		
				        	} else if(input2.equals("3")) {
				        		AccountDAO d = new AccountDAOImpl();
				        		User b = r.getUserByName(uName);
				        		System.out.println("Which account would you like to make a deposit in? Enter the account number");
				        		for (Account c : d.getAccountsByID(b.getId())) {
				        			System.out.println("Account: " + c.getAccountNum() + " Balance: " + c.getBalance());
				        		}
				        		
				        		int acc = Integer.parseInt(scan.nextLine());
				        		System.out.println("How much money would you like to deposit?");
				        		String money = scan.nextLine();
				        		double deposit = Double.parseDouble(money);
				        		double newBal = d.transacation(acc, deposit);
				        		System.out.println("Deposit successful. Your new balance is $" + newBal + " . Hit enter to return to the main menu");
				        		String next = scan.nextLine();
				        		
				        	} else if(input2.equals("4")) {
				        		AccountDAO d = new AccountDAOImpl();
				        		User b = r.getUserByName(uName);
				        		System.out.println("Which account would you like to make a withdrawal from? Enter the account number");
				        		for (Account c : d.getAccountsByID(b.getId())) {
				        			System.out.println("Account: " + c.getAccountNum() + " Balance: " + c.getBalance());
				        		}
				        		
				        		
				        		int acc = Integer.parseInt(scan.nextLine());
				        		System.out.println("How much money would you like to withdraw?");
				        		String money = scan.nextLine();
				        		double withdraw = Double.parseDouble(money);
				        		double balance = 0;
				        		
				        		for (Account p : d.getAccountsByID(b.getId())) {
				        			if(p.getAccountNum() == acc) {
				        				balance = p.getBalance();
				        			}
				        		}
				        		int redo = 0;
				        		while(redo != 1) {
					        		if(withdraw > balance ) {
					        			System.out.println("You can't withdraw more then your balance. You balance is " + balance +" .Re-enter withdrawal amount.");
					        			money = scan.nextLine();
						        		withdraw = Double.parseDouble(money);
					        		} else {
					        			withdraw = -withdraw;
						        		double newBal = d.transacation(acc, withdraw);
						        		System.out.println("Withdrawal successful. Your new balance is $" + newBal + " . Hit enter to return to the main menu");
						        		redo = 1;
						        		String next = scan.nextLine();
					        		}
				        		
				        		}
				        		
				        	}
			        	
			        	}
			        	
			        }
			        	
		        } else if(input.equals("2")) {
		        	System.out.println("Enter superuser username");
		        	String uName = scan.nextLine();
		        	UserDAO r = new UserDAOImpl();
		        	if(uName.equals("gsingh34")) {
		        		System.out.println("Enter your password");
		        		String pass = scan.nextLine();
		        		r.checkPass(uName, pass);
		        		System.out.println("You have successfuly logged in as the superuser. Hit enter to continue.");
		        		scan.nextLine();
		        		int back = -1;
		        		while (back != 4) {
		        			System.out.println("Enter one of the following values: ");
		        			System.out.println("0: To view all existing users.");
		        			System.out.println("1: To create a user");
		        			System.out.println("2: To update a users information");
		        			System.out.println("3: To delete a user");
		        			System.out.println("4: To logout of your superuser account");
			        		String sup = scan.nextLine();
			        		if(!(sup.equals("0") || sup.equals("1") || sup.equals("2") || sup.equals("3") || sup.equals("4"))) {
				        		System.out.println("Invalid entry. You must enter one of the numbers you were prompted to enter.");
					        	System.out.println("Hit enter to get see your options again ");
					        	scan.nextLine();
				        	} else {
				        		back = Integer.parseInt(sup);
				        		if(sup.equals("0")) {
				        			System.out.println("Here is a list of all the viewers");
				        			UserDAO d = new UserDAOImpl();
					        		for (User c : d.getUsers()) {
					        			System.out.println(c);
					        		}
					        		System.out.println("Hit enter to go back to the main menu");
					        		String nex = scan.nextLine();
					        		
				        		}else if(sup.equals("1")) {
				        			System.out.println("Enter a username.");
				    	        	String userName = scan.nextLine();
				    	        	UserDAO h = new UserDAOImpl();
				    	        	int wrong = -1;
						        	while (wrong == -1) {
							        	try {
							        		h.uniqueUsername(userName);
								        	wrong = 0;
							        	} catch(LoginException e) {
							        		System.out.println(e);
							        		System.out.println("Enter a username. Username must be less then 21 characters and can use any combination"
								        			+ " of characters");
								        	userName = scan.nextLine();
							        	}
						        	}
				    	        	System.out.println("Enter a password.");
				    	        	String password = scan.nextLine();
				    	        	System.out.println("Enter your first Name");
				    	        	String fName = scan.nextLine();
				    	        	System.out.println("Enter your last name");
				    	        	String lName = scan.nextLine();
				    	        	System.out.println("Enter your eMail");
				    	        	String eMail = scan.nextLine();
				    	            User a = new User(10, fName, lName, userName, password, eMail, 2);
				    	            r.createUser(a);
				    	            System.out.println("User created. Hit enter to go back to the main menu");
					        		String nex = scan.nextLine();
				        		}else if(sup.equals("2")) {
				        			System.out.println("Here is a list of all the viewers");
				        			UserDAO d = new UserDAOImpl();
					        		for (User c : d.getUsers()) {
					        			System.out.println(c);
					        		}
					        		
					        		System.out.println("Enter the id of the user you would like to update");
					        		int updateId = Integer.parseInt(scan.nextLine());
					        		System.out.println("Enter new username for the user");
					        		String userName = scan.nextLine();
					        		System.out.println("Enter new password for the user");
				    	        	String password = scan.nextLine();
				    	        	System.out.println("Enter new first Name for the user");
				    	        	String fName = scan.nextLine();
				    	        	System.out.println("Enter new last name for the user");
				    	        	String lName = scan.nextLine();
				    	        	System.out.println("Enter new eMail for the user");
				    	        	String eMail = scan.nextLine();
				    	        	User j = new User(updateId, fName, lName, userName, password, eMail, 2);
				    	        	d.updateUser(j);
				    	        	System.out.println("User updated. Press enter to go back to the main menu");
				    	        	String nex = scan.nextLine();
		
				        		}else if(sup.equals("3")) {
				        			System.out.println("Here is a list of all the viewers");
				        			UserDAO d = new UserDAOImpl();
					        		for (User c : d.getUsers()) {
					        			System.out.println(c);
					        		}
					        		
					        		System.out.println("Enter the id of the user you would like to delete");
					        		String delUser = scan.nextLine();
					        		int delId = Integer.parseInt(delUser);
					        		AccountDAO z = new AccountDAOImpl();
					        		if (!(z.getAccountsByID(delId).isEmpty())) {
						        		for(Account x : z.getAccountsByID(delId)) {
						        			int wrong = -1;
						        			double canDel = x.getBalance();
								        	while (wrong == -1) {
									        	try {
									        		z.deleteAccount(x.getAccountNum(), canDel);
										        	wrong = 0;
										        	System.out.println("Account successfully deleted. Hit enter to go back to the main menu");
									        	} catch(BankException e) {
									        		System.out.println(e);
									        		String shouldW = scan.nextLine();
									        		if(shouldW.equals("1")) {
									        			canDel = - canDel;
									        			canDel = z.transacation(x.getAccountNum(), canDel);
									        		} else {
									        			wrong = 0;
									        			System.out.println("Hit enter to return to the main menu");
									        			scan.hasNextLine();
									        		}
						        			
									        	}
									        	
								        	}
								        	
						        		}
					        		
					        		}
					        		
					        		d.deleteUser(delId);
					        		System.out.println("User deleted. Hit enter to return to the main menu");
					        		scan.nextLine();
					        		
				        		}
				        		
				        		
			        		
				        	}
			        		
		        		}
		        	
		        	} else {
		        		System.out.println("You are not the superuser. Hit enter to be returned to the main menu");
		        		scan.nextLine();
		        		
		        	}
		        	
		        }
		        	
		    }
	        
		}  
	}
	
}
