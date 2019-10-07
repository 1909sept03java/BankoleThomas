package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementsDAOImpl;

@WebServlet("/createReim")
public class CreateReimServlet extends HttpServlet {

	private static final long serialVersionUID = 8963444282420917325L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		ReimbursementsDAOImpl reim = new ReimbursementsDAOImpl();
		System.out.println(Double.parseDouble(req.getParameter("reimBal")));
		System.out.println(session.getAttribute("name"));
		reim.createReimbursements(Double.parseDouble(req.getParameter("reimBal")), session.getAttribute("name").toString());
		if (session != null && session.getAttribute("manager").equals(null)) {
			System.out.println("MANAGER ");
			req.getRequestDispatcher("Ma_Homepage.html").forward(req, resp);
		} else {
			resp.sendRedirect("Em_Homepage.html");
		}
	}
	
}