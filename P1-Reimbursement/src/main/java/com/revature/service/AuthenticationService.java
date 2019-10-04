package com.revature.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeesDAOImpl;
import com.revature.beans.Credentials;
import com.revature.beans.Employees;


public class AuthenticationService {
	
		
		// if credentials are not recognized, return null
		// if they are, return Employees associated with them
		public Employees authenticateEmployees(Credentials creds) throws SQLException, IOException, ClassNotFoundException {
			Employees u = null;
			

			String Employeesname = creds.getUsername();
			String password = creds.getPassword();
					
					  

					try (Connection conn = ConnectionService.getConnection()) {
						System.out.println("here1");
						String sql = "SELECT COUNT(NAME_) AS COUNT, NAME_,EMP_ID,PASSWORD_,MANAGER_ FROM EMPLOYEES WHERE NAME_ = ? AND PASSWORD_ = ? GROUP BY NAME_,PASSWORD_,EMP_ID,MANAGER_";
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, Employeesname);
						pstmt.setString(2, password);
						
						ResultSet rs= pstmt.executeQuery();
						System.out.println("here2");

						while(rs.next()) {
							System.out.println("query successful");
							int checker = rs.getInt("COUNT");
							String name = rs.getString("NAME_");
							
							int id = rs.getInt("EMP_ID");
							String admin = rs.getString("MANAGER_");
							if(checker>0) {
								
								u = new Employees(id,name,password, admin);
								
								
							
								
							}
									
			
		}}catch(SQLException e){ e.printStackTrace(); 
		Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("here");
		}
					return u;}}