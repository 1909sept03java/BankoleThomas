package com.revature.util;

public class WrongUserException extends Exception {

	public WrongUserException()  {
		System.out.println("Wrong password");
	}
}
