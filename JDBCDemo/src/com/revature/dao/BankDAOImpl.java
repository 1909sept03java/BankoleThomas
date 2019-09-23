package com.revature.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.revature.beans.Account;
import com.revature.beans.Bank;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.OverdraftException;
import com.revature.util.WrongPasswordException;
import com.revature.util.WrongUserException;

import java.util.Scanner;

public class BankDAOImpl implements BankDAO {
	
	
	static Scanner scan = new Scanner(System.in);

		public static String Confirmation(String USERNAME, String PASSWORD) throws WrongPasswordException, WrongUserException, IOException {
			String check = null;
			
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				String sql = "SELECT USERNAME_ FROM USER_ WHERE USERNAME_= ? AND PASSWORD_ =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, USERNAME);
				stmt.setString(2, PASSWORD);
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					
					check = rs.getString("USERNAME_");
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
//			if (check.equals(USERNAME) ) {
//				
//				System.out.println("YOU HAVE LOGGED IN");
//				System.out.println("WOULD YOU LIKE CREATE AN ACCOUNT,"
//						+ "Y OR N");
//				String response=scan.nextLine();
//				
//				
//				
//			}
	return check;
			
		}
		
		public void LogIn() throws IOException, WrongPasswordException, WrongUserException 
			{
				System.out.println("Whats your username");
				String USERNAME = scan.nextLine();
				System.out.println("Whats your password");
				String PASSWORD = scan.nextLine();
				
				
					String USER_ID = Confirmation(USERNAME, PASSWORD);
				
				
			}
		
		
		
		
		public void UserOption(int USER_ID) throws IOException {
			if(USER_ID==0) {
			try {
				System.out.println("Logging into SUPERUSER");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} AdminOption(); }
			else {
			System.out.println("Logging into USER ID: " + USER_ID); UserOption(USER_ID);
			}
		}

		public void AdminOption() throws IOException{
			char option = '1';
			if(option != '0') {
				System.out.println("What would you like to do\n0) "
						+ "Create user\n1)  "
						+ "Delete user\n2)"
						+ " View user\n3) "
						+ "Log out");
				try {
					option = scan.nextLine().charAt(0);
				} catch(StringIndexOutOfBoundsException e) {
					
				}
				if (option=='1') {
				 try {
					createUser();
				} catch (StringIndexOutOfBoundsException e) {
					//e.printStackTrace();
				} 
				
				if(option== '3') {
					DeleteUser(); 
				}
				if(option== '4') {
					ViewUser(); 
				}
				if(option== '5') {
					
				}
				if(option == '0'){
					System.out.println("Logging out");
					} 
				else { System.out.println(option + "is not an option\n");
				}	}}
			
		}
		

		@Override
		public void createAccount(int USER_ID) throws IOException {
			
			System.out.println("Whats your initial amount?");
			double Amount = 0;
			boolean flag= true;
			while(flag==true) {
			try {
				Amount = Double.parseDouble(scan.nextLine());
			} catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid input");
				createAccount( USER_ID);
			}
			
			if (Amount < 0) {
				System.out.println("Enter an amount greater than $0.00");
				createAccount(USER_ID);
				return;
			}
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				String sql = "INSERT INTO ACCOUNTS_(USER_ID,AMOUNT)VALUES(?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, USER_ID);
				stmt.setDouble(2, Amount);
				stmt.execute();

				System.out.println("Amount Deposited");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			System.out.println("Account has been created, returning to menu");
		}}
		



		@Override
		public void UpdateAccount(int USER_ID) throws NumberFormatException, IOException {
			System.out.println("Account number ?"
					+ "+/n Press 0 to exit");
			int ACCOUNT_NO = 0;
			try{
				ACCOUNT_NO = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid input");
				UpdateAccount(USER_ID);
			}
			if (ACCOUNT_NO == 0)
				return;
			
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				String sql = "SELECT * FROM ACCOUNTS_ WHERE USER_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, USER_ID);
				pstmt.executeQuery();
				ResultSet rs = pstmt.executeQuery();
				boolean temp = false;
				while(rs.next()) {
					int A_NO = rs.getInt("ACCOUNT_NO");
					int user_id = rs.getInt("USER_ID");
					double Amount = rs.getDouble("Amount");
				if (ACCOUNT_NO == A_NO) {
						temp = true;
						break;
					}
				}
				if (temp == false) {
					System.out.println("Access Denied");
					return;
				}
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			System.out.println("Withdraw\n2)"
					+ " Deposit\n0) "
					+ "Return to the menu");
			int option = 0;
			try{
				option = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid input");
				return;			
			}
			if (option == 0)
				return;
				double amount;
			if(option==0) {
				return;}
			if(option==1) 
				{System.out.println("Withdrawl Amount");
				try{
					amount = Double.parseDouble(scan.nextLine()) * -1;
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					System.out.println("Invalid input");
					return;
				}
				
			}else {
			 System.out.println("Invalid option"); }
			}
		
		
		public void DeleteUser() throws IOException {
			System.out.println("What user would you like to delete");
			int USER_ID = 0; 
			try{
				USER_ID = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException e) {
				return;
			} 
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				String sql = "DELETE FROM USER_ WHERE USER_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, USER_ID);
				pstmt.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				System.out.println("Delete all records from account?");
				int option = 0; 
				try{
					option = Integer.parseInt(scan.nextLine());
				} catch(NumberFormatException e1) {
					
				}if(option == 1){
					System.out.println("USER HAS BEEN DELETED");
				}
				} catch (SQLException e) {
			
				
			}
		}
//		public static void run() {
//		ViewUser();	
//		}
		@Override
		public void ViewUser() throws IOException {
			System.out.println("ENTER USER_ID  to see all, or enter to cancel");
			int USER_ID;
			try{
				USER_ID = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException e) {
				return;
			}
			if (USER_ID == 9) {
				try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
					User u = null;
					String sql = "SELECT * FROM USER_ ORDER BY USER_ID";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						int user_id = rs.getInt("USER_ID");
						String username = rs.getString("USERNAME");
						String password = rs.getString("PASSWORD");
						u = new User(user_id, username,password);
						System.out.println(u);
					}
				} catch (SQLException e) {
					
				}
				return;
			}
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				User u = null;
				String sql = "SELECT * FROM USER_ WHERE USER_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, USER_ID);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int user_id = rs.getInt("USER_ID");
					String username = rs.getString("USERNAME");
					String password = rs.getString("PASSWORD");
					u = new User(user_id, username, password);
					System.out.println(u);				
				}
			} catch (SQLException e) {
				
			}
		}
		
		public void ViewAccounts(int USER_ID) throws IOException {
			Account a = null;
			try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
				String sql = "SELECT * FROM ACCOUNTS_ WHERE USER_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, USER_ID);
				pstmt.executeQuery();
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int A_NO = rs.getInt("ACCOUNT_NO");
					int user_id = rs.getInt("USER_ID");
					double AMOUNT = rs.getDouble("AMOUNT");
					a = new Account(A_NO, user_id, AMOUNT);
					System.out.println(a);				
				}
			} catch (SQLIntegrityConstraintViolationException e) {
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
		}



			@Override
			public void createUser() throws IOException  {
				System.out.println("Thank you For Banking with us Please Follow Directions");
				System.out.println("Please give us a user name");
				String USERNAME = scan.nextLine();
				if (USERNAME.charAt(0) == '0')
					return;
				if (USERNAME.contains(" ")) {
					System.out.println("Invalid input, don't use spaces");
					createUser();
					return;
				}
				System.out.println("Input password");
				String PASSWORD = scan.nextLine();
				if (PASSWORD.contains(" ")) {
					System.out.println("Invalid input, don't use spaces");
					createUser();
					return;
				}
				try {
					Properties prop = new Properties();
					prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
					String superUsername = prop.getProperty("username");
					String superPassword = prop.getProperty("password");
					if (USERNAME.equals(superUsername) && PASSWORD.equals(superPassword)) {
						System.out.println("USERNAME is already taken, please use another");
						return;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try (Connection conn = ConnectionUtil.getConnection("connection.properties")) {
					String sql = "INSERT INTO USER_(USERNAME, PASSWORD) VALUES (?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, USERNAME);
					pstmt.setString(2, PASSWORD);
					pstmt.executeUpdate();
				} catch (SQLIntegrityConstraintViolationException e) {
					e.printStackTrace();
					System.out.println("USERNAME is already taken, please use another");
					createUser();
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
				}}}

		
			
				
				
		
		


			
		
