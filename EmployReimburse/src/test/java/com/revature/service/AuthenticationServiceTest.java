package com.revature.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;

public class AuthenticationServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticateUser() {
		boolean actual = false;
		Credentials c = new Credentials(3, 3, "JHalpert", "mypass123");
		AuthenticationService aS = new AuthenticationService();
		Employee authorizedEmployee = new Employee();
		authorizedEmployee = aS.authenticateUser(c);
		if(authorizedEmployee.getEmail().equals("JHalpert@gmail.com")) {
			actual = true;	
		}
		
		assertTrue(actual);
		
	}

}
