package project.beans;

public class Account {
	
	private int accountID;
	private int accountNum;
	private double balance;
	private int userID;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountID, int accountNum, double balance, int userID) {
		super();
		this.accountID = accountID;
		this.accountNum = accountNum;
		this.balance = balance;
		this.userID = userID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountNum=" + accountNum + ", balance=" + balance + ", userID="
				+ userID + "]";
	}	

}
