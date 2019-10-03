package com.revature.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeDAOImplTest {

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
	public void testGetEmployees() {
		boolean actual = false;
		EmployeeDAO employD = new EmployeeDAOImpl();
		List<Employee> eList = new ArrayList<Employee>();
		eList = employD.getEmployees();
		for(Employee e: eList) {
			if(e.getUsername().equals("JHalpert"))
				actual = true;
		}
		
		assertTrue(actual);
		 
	}

	@Test
	public void testGetEmployeeByManager() {
		boolean actual = false;
		EmployeeDAO employD = new EmployeeDAOImpl();
		List<Employee> eList = new ArrayList<Employee>();
		eList = employD.getEmployeeByManager(2);
		for(Employee e: eList) {
			if(e.getUsername().equals("JHalpert"))
				actual = true;
		}
		
		assertTrue(actual);
	}

	@Test
	public void testGetEmployeeById() {
		boolean actual = false;
		EmployeeDAO employD = new EmployeeDAOImpl();
		Employee e = employD.getEmployeeById(3);
		if(e.getUsername().equals("JHalpert"))
			actual = true;
		
		assertTrue(actual);
	}

	@Test
	public void testUpdateEmployeeInfo() {
		Employee employ = new Employee(3, "JHalpert", "mypass123", "JHalpert@gmail.com", 2);
		boolean actual = false;
		EmployeeDAO employD = new EmployeeDAOImpl();
		employD.updateEmployeeInfo(employ);
		Employee e = employD.getEmployeeById(3);
		if(e.getEmail().equals("JHalpert@gmail.com"))
			actual = true;
		
		assertTrue(actual);
	}

}
