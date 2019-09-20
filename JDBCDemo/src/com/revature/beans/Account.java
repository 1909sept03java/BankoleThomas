package com.revature.beans;

public class Account {

private	int A_NO;
private int user_id;
private double AMOUNT;


public Account(int a_NO, int user_id, double aMOUNT) {
	super();
	A_NO = a_NO;
	this.user_id = user_id;
	AMOUNT = aMOUNT;
}


public Account() {
	super();
	// TODO Auto-generated constructor stub
}


public int getA_NO() {
	return A_NO;
}


public void setA_NO(int a_NO) {
	A_NO = a_NO;
}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public double getAMOUNT() {
	return AMOUNT;
}


public void setAMOUNT(double aMOUNT) {
	AMOUNT = aMOUNT;
}


@Override
public String toString() {
	return "Account [A_NO=" + A_NO + ", user_id=" + user_id + ", AMOUNT=" + AMOUNT + ", getA_NO()=" + getA_NO()
			+ ", getUser_id()=" + getUser_id() + ", getAMOUNT()=" + getAMOUNT() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}



}

