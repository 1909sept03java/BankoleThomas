package com.revature.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Bank;
import com.revature.util.WrongPasswordException;
import com.revature.util.WrongUserException;


public interface BankDAO {
	

	


		
		
		public void UpdateAccount(int USER_ID) throws NumberFormatException, IOException;
		public void UserOption(int USER_ID) throws IOException;
		public void AdminOption() throws IOException;
		public void ViewUser() throws IOException;
		public void ViewAccounts(int USER_ID) throws IOException;
		
		public void LogIn() throws IOException, WrongPasswordException, WrongUserException;
		void createUser() throws SQLException, IOException;
		public void createAccount(int USER_ID) throws IOException;
		
		
		
		
}
