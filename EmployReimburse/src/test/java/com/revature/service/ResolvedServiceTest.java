package com.revature.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.ResolvedRequests;

public class ResolvedServiceTest {

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
	public void testGetAllResolved() {
		boolean actual = false;
		ResolvedService rs = new ResolvedService();
		List<ResolvedRequests> rList = new ArrayList<ResolvedRequests>();
		rList = rs.getAllResolved();
		for(ResolvedRequests rr: rList) {
			if(rr.getDetail().equals("CPR Training")) {
				actual = true;
				
			}
			
		}
		
		assertTrue(actual);
		
	}

}
