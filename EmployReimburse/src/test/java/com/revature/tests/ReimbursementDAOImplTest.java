package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ReimbursementDAOImplTest {

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
	public void testGetReimbursements() {
		boolean actual = false;
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reimburse.getReimbursements();
		for(Reimbursement r: rList) {
			if(r.getReimburseId() == 2)
				actual = true;
		}
		
		assertTrue(actual);
	}

	@Test
	public void testGetReimbursementsByEmployId() {
		boolean actual = false;
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reimburse.getReimbursementsByEmployId(3);
		for(Reimbursement r: rList) {
			if(r.getReimburseId() == 21)
				actual = true;
		}
		
		assertTrue(actual);
	}

	@Test
	public void testGetReimbursementsByStatus() {
		boolean actual = false;
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reimburse.getReimbursementsByStatus(0);
		for(Reimbursement r: rList) {
			if(r.getReimburseId() == 22)
				actual = true;
		}
		
		assertTrue(actual);
	}

	@Test
	public void testCreateReimbursements() {
		boolean actual = false;
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		reimburse.createReimbursements(100, 5, "Lunch");
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reimburse.getReimbursementsByStatus(0);
		for(Reimbursement r: rList) {
			if(r.getDetail().equals("Lunch"))
				actual = true;
		}
		
		assertTrue(actual);
	}

	@Test
	public void testResolveReimbursements() {
		int actual = 0;
		int expected = 2;
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		reimburse.resolveReimbursements(41, 2);
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reimburse.getReimbursementsByStatus(2);
		for(Reimbursement r: rList) {
			if(r.getReimburseId() == 41)
				actual = r.getStatus();
		}
		
		assertEquals(expected, actual);
	}

}
