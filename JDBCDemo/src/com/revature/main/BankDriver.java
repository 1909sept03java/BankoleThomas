package com.revature.main;

import java.io.IOException;
import java.sql.Connection;

import com.revature.beans.Bank;
import com.revature.beans.Cave;
import com.revature.dao.BankDAO;
import com.revature.dao.BankDAOImpl;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.ConnectionUtil;
import java.util.Scanner;
import com.revature.beans.Account;
import com.revature.util.WrongUserException;
import com.revature.beans.User;
import com.revature.util.WrongPasswordException;
import com.revature.util.OverdraftException;



public class BankDriver {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException, WrongPasswordException, WrongUserException {
		BankDAO dao = new BankDAOImpl();
		
		
		char choices = '1';
		if(choices != '0') {
			System.out.println("Select:\n1) "
					+ "Log In"
					+ "\n2) "
					+ "Register\n0) "
					+ "Exit");
			try { 
				choices = scan.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				
			}
			if (choices=='1') {
			dao.LogIn();}
			if(choices=='2') {
			 try {
				//dao.createAccount();
			} catch (StringIndexOutOfBoundsException e) {
				//e.printStackTrace();
			}
			
			if(choices=='0') { System.out.println("Exiting"); 
			}
			else {  System.out.println(choices + "  wrong input\n");
			}	
		}}}{}}
			
		
	


		
//		
//		
//	}
		


