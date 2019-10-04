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

	public List<Employees> getEmployees() {

		
		List<Employees> empList = new ArrayList<Employees>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String employeeUsername = rs.getString("NAME_");
				String employeePassword = rs.getString("PASSWORD_");
				String employeeManagerId = rs.getString("MANAGER_");

				empList.add(new Employees(employeeId, employeeUsername, employeePassword,employeeManagerId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	public Employees getEmployeesById(int employeeId) {
		
		
		Employees emp = new Employees();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String employeeUsername = rs.getString("NAME_");
				String employeePassword = rs.getString("PASSWORD_");
				//int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				emp.setEmployeeId(employeeId);
				emp.setEmployeeUsername(employeeUsername);
				emp.setEmployeePassword(employeePassword);
				//emp.setEmployeeManagerId(employeeManagerId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public void updateEmployees(double parseDouble, String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	

}