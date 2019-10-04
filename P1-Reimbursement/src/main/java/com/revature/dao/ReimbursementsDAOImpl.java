package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursements;
import com.revature.service.ConnectionService;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	@Override
	public List<Reimbursements> getReimbursements() {

		/*
		 * this function will reach into the database and pull out all of the data,
		 * storing it into an ArrayList object and returning it
		 */

		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM TRANSACTIONS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				double reimbursementBalance = rs.getDouble("RE_AMOUNT");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				String name = rs.getString("NAME_");
				reimList.add(
						new Reimbursements(reimbursementBalance, reimbursementStatus, name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimList;
	}

	@Override
	public List<Reimbursements> getReimbursementsByName(String name) {

		/*
		 * this function will reach into the database and pull out all of the data,
		 * storing it into an ArrayList object and returning it
		 */

		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM TRANSACTIONS WHERE NAME_ = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				double reimbursementBalance = rs.getDouble("RE_AMOUNT");
				String reimbursementStatus = rs.getString("STATUS"); // P = pending, D = deny, A = allow
				reimList.add(
						new Reimbursements(reimbursementBalance, name, reimbursementStatus));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimList;
	}

	@Override
	public void createReimbursements(double reimbursementBalance, String name) {

		try (Connection con = ConnectionService.getConnection();) {
			String sql = "INSERT INTO TRANSACTIONS(RE_AMOUNT,STATUS,NAME_) VALUES(?, 'Pending', ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, reimbursementBalance);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursements(String name, String reimbursementStatus) {

		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE TRANSACTIONS SET STATUS = ? WHERE NAME_ = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reimbursementStatus);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReimbursements() {
		// TODO Auto-generated method stub

	}

	public List<Reimbursements> AllPending() {
		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM TRANSACTIONS WHERE STATUS = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Pending");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				double reimbursementBalance = rs.getDouble("RE_AMOUNT");
				String reimbursementStatus = rs.getString("STATUS"); 
				String name = rs.getString("NAME_");
				reimList.add(
						new Reimbursements( reimbursementBalance, reimbursementStatus, name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimList;
	}
	
	}


