package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursements;
import com.revature.dao.ReimbursementsDAOImpl;

@WebServlet("/getAllPending")
public class PendingServlet extends HttpServlet {

	private static final long serialVersionUID = 8742540279202028594L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			
			ReimbursementsDAOImpl reimDAO = new ReimbursementsDAOImpl();
			List<Reimbursements> reimList = reimDAO.AllPending();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(reimList));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}