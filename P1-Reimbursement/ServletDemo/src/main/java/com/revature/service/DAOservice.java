package com.revature.service;


import java.util.List;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.dao.EmployeesDAO;
import com.revature.dao.EmployeesDAOImpl;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImpl;


public class DAOservice {
	
	
	public static List<Employees> getEmployees() {
		EmployeesDAO emp = new EmployeesDAOImpl();
		return emp.getEmployees();
	}
	
	public static Employees getEmployeesById(int employeeId) {
		EmployeesDAO emp = new EmployeesDAOImpl();
		return emp.getEmployeesById(employeeId);
	}

	public static boolean updateEmployees(int employeeId, String username, String password) {
		EmployeesDAO emp = new EmployeesDAOImpl();
		emp.updateEmployees(employeeId, username, password);
		return true;
	}

}
