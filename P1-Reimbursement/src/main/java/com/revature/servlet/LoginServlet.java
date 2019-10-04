package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employees;

import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {
	
	private AuthenticationService authService = new AuthenticationService();
	private static final long serialVersionUID = 817105812389880890L;

	/*
	 * Create two methods: - a doGet to handle GET requests for our login page - a
	 * doPost to handle POST requests with credentials
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("Login.html").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check whether a session already exists, and create one if not 
		// overloaded version take a boolean parameter, if false returns null if not session exists
		// matching the incoming request's JSESSIONID token
		System.out.println("works");
		HttpSession session = req.getSession();
		// grab credentials from the request - use getParameter for form data
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		// pass responsibility for performing auth logic to a service
		Employees u = null;
		try {
			u = authService.authenticateEmployees(creds);
		} catch (SQLException e) {
			// TODO Auto-generatexd catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u != null) {
			// they're real 
			// set user information as session attributes (not request attributes)
			System.out.println("works");

			session.setAttribute("userId", u.getEmployeeId());
			session.setAttribute("name", u.getEmployeeUsername());
			session.setAttribute("password", u.getEmployeePassword());
			session.setAttribute("manager", u.getEmployeeManagerId());
			session.setAttribute("problem", null);
			System.out.println( session.getAttribute("userId"));
			System.out.println( session.getAttribute("manager"));
			
			if(u.getEmployeeManagerId().equals("Y")) {
				System.out.println("We made it");
				req.getRequestDispatcher("Ma_Homepage.html").forward(req, resp);
				
			}
			else if(u.getEmployeeManagerId().equals("N")) {
				req.getRequestDispatcher("Em_Homepage.html").forward(req, resp);
				
			
			}
		} else {
			// they're not real
			session.setAttribute("problem", "invalid credentials");
			System.out.println("works");
			// resp.getWriter().write("invalid credentials");
			// redirect back to login
			resp.sendRedirect("login");
		}
	}
}
