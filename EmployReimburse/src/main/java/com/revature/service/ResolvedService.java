package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.ResolvedRequests;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ResolvedService {
	
	public List<ResolvedRequests> getAllResolved() {
		
		ReimbursementDAO rd = new ReimbursementDAOImpl();
		List<Reimbursement> resolved = rd.getReimbursementsByStatus(1);
		for(Reimbursement r: rd.getReimbursementsByStatus(2)) {
			resolved.add(r);
		}
		
		List<ResolvedRequests> allResolved = new ArrayList<ResolvedRequests>();
		for(Reimbursement r: resolved) {
			EmployeeDAO ed = new EmployeeDAOImpl();
			Employee employ = ed.getEmployeeById(r.getEmployId());
			Employee manager = ed.getEmployeeById(employ.getManagerId());
			String username = employ.getUsername();
			String status = "";
			if(r.getStatus() == 1) {
				status = "Approved";
			} else 
				status = "Denied";
			
			double amount = r.getAmount();
			String detail = r.getDetail();
			String man = manager.getUsername();
			
			ResolvedRequests rRequests = new ResolvedRequests(username, status, amount, detail, man);
			allResolved.add(rRequests);
		
		}
		
		return allResolved;
		
	}

}
