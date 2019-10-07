package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employees;
import com.revature.service.ConnectionService;

public class EmployeesDAOImpl implements EmployeesDAO{

	@Override
	public List<Employees> getEmployees() {

		

		List<Employees> empList = new ArrayList<Employees>();
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			// getting the result set
			ResultSet rs = ps.executeQuery();
			// looping through the result set
			while (rs.next()) {
				// getting the information for an employee object
				int employeeId = rs.getInt("EMP_ID");
				String employeeUsername = rs.getString("NAME_");
				String employeePassword = rs.getString("PASSWORD_");
				String employeeManager = rs.getString("MANAGER_");
				// pushing that employee into the list of employee's
				empList.add(new Employees(employeeId, employeeUsername, employeePassword, employeeManager));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// returning the employee list
		return empList;
	}


	@Override
	public Employees getEmployeesById(int employeeId) {

		
		Employees emp = new Employees();
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// setting the employee id of the query string
			ps.setInt(1, employeeId);
			// getting the result set
			ResultSet rs = ps.executeQuery();
			// looping through the result set
			while (rs.next()) {
				
				emp.setEmployeeId(employeeId);
				emp.setEmployeeUsername(rs.getString("NAME_"));
				emp.setEmployeePassword(rs.getString("PASSWORD_"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void updateEmployees(int employeeId, String username, String password) {
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "UPDATE EMPLOYEES SET NAME_ = ?, PASSWORD_ = ? WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// setting the username, password, and employee id of the query string
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, employeeId);
			// execute the query and update the database
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}


	
	

}