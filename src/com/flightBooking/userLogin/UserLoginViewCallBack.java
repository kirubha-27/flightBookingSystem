package com.flightBooking.userLogin;

import com.flightBooking.dto.User;

public interface UserLoginViewCallBack {
	public void loginSuccess(User user);
	public void loginFailure(String errorMessage);
}
