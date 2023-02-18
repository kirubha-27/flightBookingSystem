package com.flightBooking.userLogin;

import com.flightBooking.dto.User;

public interface UserLoginControllerModelCallBack {
	public void loginSuccess(User user);
	public void loginFailure(String errorMessage);
}
