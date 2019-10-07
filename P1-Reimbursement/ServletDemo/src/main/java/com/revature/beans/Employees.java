package com.revature.beans;


public class Employees { 

	
int employeeId;
String employeeUsername;
String employeePassword;
String employeeManagerId;

public Employees() {
	super();
}
public Employees(int employeeId, String employeeUsername, String employeePassword, String employeeManagerId2) {
	super();
	this.employeeId = employeeId;
	this.employeeUsername = employeeUsername;
	this.employeePassword = employeePassword;
	
	this.employeeManagerId = employeeManagerId2;
}
@Override
public String toString() {
	return "\"employeeId\":"+this.employeeId+",\"employeeUsername\":\""+this.employeeUsername+"\",\"employeePassword\":\""+this.employeePassword +"\",\"employeeManagerId\":"+this.employeeManagerId;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + employeeId;
	result = prime * result + ((employeeManagerId == null) ? 0 : employeeManagerId.hashCode());
	result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
	result = prime * result + ((employeeUsername == null) ? 0 : employeeUsername.hashCode());
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
	Employees other = (Employees) obj;
	if (employeeId != other.employeeId)
		return false;
	if (employeeManagerId == null) {
		if (other.employeeManagerId != null)
			return false;
	} else if (!employeeManagerId.equals(other.employeeManagerId))
		return false;
	if (employeePassword == null) {
		if (other.employeePassword != null)
			return false;
	} else if (!employeePassword.equals(other.employeePassword))
		return false;
	if (employeeUsername == null) {
		if (other.employeeUsername != null)
			return false;
	} else if (!employeeUsername.equals(other.employeeUsername))
		return false;
	return true;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeUsername() {
	return employeeUsername;
}
public void setEmployeeUsername(String employeeUsername) {
	this.employeeUsername = employeeUsername;
}
public String getEmployeePassword() {
	return employeePassword;
}
public void setEmployeePassword(String employeePassword) {
	this.employeePassword = employeePassword;
}

public String getEmployeeManagerId() {
	return employeeManagerId;
}
public void setEmployeeManagerId(String employeeManagerId) {
	this.employeeManagerId = employeeManagerId;
}
public Object getId() {
	// TODO Auto-generated method stub
	return null;
}
public Object getIsManager() {
	// TODO Auto-generated method stub
	return null;
}

}
