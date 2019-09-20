package com.revature.beans;

public class Bank {
	private static int account;
	private String USERNAME_;
	private String password;
	
	
	public Bank(int account, String uSERNAME_, String password) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [account=" + account + ", USERNAME_=" + USERNAME_ + ", password=" + password + ", hashCode()="
				+ hashCode() + ", getAccount()=" + getAccount() + ", getUSERNAME_()=" + getUSERNAME_()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((USERNAME_ == null) ? 0 : USERNAME_.hashCode());
		result = prime * result + account;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (USERNAME_ == null) {
			if (other.USERNAME_ != null)
				return false;
		} else if (!USERNAME_.equals(other.USERNAME_))
			return false;
		if (account != other.account)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	public static int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getUSERNAME_() {
		return USERNAME_;
	}
	public void setUSERNAME_(String uSERNAME_) {
		USERNAME_ = uSERNAME_;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
