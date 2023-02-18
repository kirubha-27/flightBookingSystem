package com.flightBooking.dto;

public class UserCredentials extends User {
	private String password;
	
	public UserCredentials(int userId, String userName ,String password) {
		super.setUserId(userId);
		super.setUserName(userName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
