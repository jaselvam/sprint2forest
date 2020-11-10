package com.forest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Controller12")
public class User {
	@Id
	private String userName;
	private String userPassword;
	private String role;
	
	public User() {
		super();
	}
	public User(String userName, String userPassword, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", role=" + role
				+ "]";
	}

	
	

}
