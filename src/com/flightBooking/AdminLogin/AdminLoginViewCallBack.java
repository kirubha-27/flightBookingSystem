package com.flightBooking.AdminLogin;

import com.flightBooking.dto.Admin;

public interface AdminLoginViewCallBack {
	public void loginSuccess(Admin admin);
	public void loginFailure(String errorMessage);
}
