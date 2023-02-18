package com.flightBooking.userLogin;

import com.flightBooking.dto.User;

public class UserLoginController implements UserLoginControllerViewCallBack,UserLoginControllerModelCallBack {
	
	private UserLoginViewCallBack userLoginView;
	
	private UserLoginModelCallBack userLoginModel;
	
	public UserLoginController(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		this.userLoginModel = new UserLoginModel(this);
	}
	
	public void checkCredentials(String userName, String password) {
		userLoginModel.checkCredentials(userName,password);
	}
	
	public void loginSuccess(User user) {
		userLoginView.loginSuccess(user);
	}
	
	public void loginFailure(String errorMessage) {
		userLoginView.loginFailure(errorMessage);
	}
}
