package com.revature.dao;
import java.util.List;

import com.revature.beans.Employees;

	

	public interface EmployeesDAO {

		/*
		 * a "contract" with some useful functions for the Employees
		 */
		
		
		public List<Employees> getEmployees();
		public Employees getEmployeesById(int employeeId);
		public void updateEmployees(double parseDouble, String string, String string2);
		
	}


