package com.revature.dao;
import java.util.List;

import com.revature.beans.Employees;

	

	public interface EmployeesDAO {

		
		
		public List<Employees> getEmployees();
		
		public Employees getEmployeesById(int employeeId);
		
		public void updateEmployees(int employeeId, String username, String password);
		
	}


