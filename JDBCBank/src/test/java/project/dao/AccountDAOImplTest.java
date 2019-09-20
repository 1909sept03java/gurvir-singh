package project.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import project.beans.Account;
import project.beans.User;

public class AccountDAOImplTest {

	@Test
	public void testGetAccounts() {
		AccountDAO a = new AccountDAOImpl();
		boolean b = false;
		for(Account c: a.getAccounts()) {
			if(c.getAccountNum() == 9001)  //If there is an account number that is 9001 then the test should pass.
				b = true;
		}
		assertTrue(b);
	}

	@Test
	public void testTransacation() { //Going to check if the final balance is going to be equal to 500 after I pass some parameters.
		double testBalance = 1000;
		AccountDAO a = new AccountDAOImpl();
		double result = a.transacation(9000, 500); //User with account 9000 already has balance of 500, so adding 500 should give that person 1000
		assertEquals(result, testBalance, 0.0001);
		
	}

}
