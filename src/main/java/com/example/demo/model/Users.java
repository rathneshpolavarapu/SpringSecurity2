package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	private String username;
	private String Password;
	
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", Password=" + Password + "]";
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public Users(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
