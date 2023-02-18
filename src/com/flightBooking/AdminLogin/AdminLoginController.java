package com.flightBooking.AdminLogin;

import com.flightBooking.dto.Admin;

public class AdminLoginController implements AdminLoginControllerViewCallBack,AdminLoginControllerModelCallBack{
	AdminLoginViewCallBack adminLoginView;
	AdminLoginModelCallBack adminLoginModel;
	public AdminLoginController(AdminLoginView adminLoginView) {
		this.adminLoginView = adminLoginView;
		this.adminLoginModel = new AdminLoginModel(this);
	}
	
	public void checkCredentials(String userName, String password) {
		adminLoginModel.checkCredentials(userName,password);
	}
	
	public void loginSuccess(Admin admin) {
		adminLoginView.loginSuccess(admin);
	}
	
	public void loginFailure(String errorMessage) {
		adminLoginView.loginFailure(errorMessage);
	}
}
