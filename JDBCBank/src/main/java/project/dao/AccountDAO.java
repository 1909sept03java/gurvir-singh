package project.dao;

import java.util.List;

import project.beans.Account;
import project.exceptions.BankException;

public interface AccountDAO {
	
	public List<Account> getAccounts();
	public List<Account> getAccountsByID(int id);
	public void createAccount(Account account);
	public void deleteAccount(int accountNum, double balance) throws BankException;
	public double transacation(int accountNum, double amount);
}
