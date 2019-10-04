package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {

	/*
	 * a "contract" with useful functions for the Reimbursements
	 */
	
	public List<Reimbursements> getReimbursements();
	public void deleteReimbursements();
	List<Reimbursements> getReimbursementsByName(String name);
	public void createReimbursements(double reimbursementBalance, String name);
	public void updateReimbursements(String name, String reimbursementStatus);
	
}
