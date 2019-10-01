package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsByEmployId(int employId);
	public List<Reimbursement> getReimbursementsByStatus(int status);
	public void createReimbursements(double amount, int employId, String detail);
	public void resolveReimbursements(int reimburseId, int status);

}
