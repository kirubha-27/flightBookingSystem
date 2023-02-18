package com.flightBooking.userLogin;

import com.flightBooking.dto.User;
import com.flightBooking.repository.FlightRepository;


public class UserLoginModel implements UserLoginModelCallBack {
	UserLoginControllerModelCallBack userLoginModel;
	
	public UserLoginModel(UserLoginControllerModelCallBack userLoginModel) {
		this.userLoginModel = userLoginModel;
	}
	
	public void checkCredentials(String userName,String password) {
		User user = FlightRepository.getInstance().checkValidUser(userName, password);
		if(user!=null) {
			userLoginModel.loginSuccess(user);
		}else {
			userLoginModel.loginFailure("Invalid user credintials");
		}
	}
}
