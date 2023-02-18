package com.flightBooking.AdminLogin;

import com.flightBooking.dto.Admin;
import com.flightBooking.repository.FlightRepository;

public class AdminLoginModel implements AdminLoginModelCallBack{
	AdminLoginControllerModelCallBack adminLoginModel;
	
	public AdminLoginModel(AdminLoginController adminLoginController) {
		this.adminLoginModel = adminLoginController;
	}
	
	public void checkCredentials(String userName, String password) {
		Admin admin = FlightRepository.getInstance().checkValidAdmin(userName, password);
		if(admin!=null) {
			adminLoginModel.loginSuccess(admin);
		}else {
			adminLoginModel.loginFailure("Invalid credentials");
		}
	}
}
