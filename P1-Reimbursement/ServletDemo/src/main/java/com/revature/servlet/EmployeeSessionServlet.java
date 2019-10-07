package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employees;

/**
 * Servlet implementation class EmployeeSessionServlet
 */
public class EmployeeSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			Employees emp = new Employees();
			emp.setEmployeeId(Integer.parseInt(session.getAttribute("userId").toString()));
			emp.setEmployeeUsername(session.getAttribute("name").toString());
			emp.setEmployeePassword(session.getAttribute("password").toString());
	
			res.getWriter().write((new ObjectMapper()).writeValueAsString(emp));
		} catch (Exception e) {
			e.printStackTrace();
			res.getWriter().write("{\"session\":null}");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
