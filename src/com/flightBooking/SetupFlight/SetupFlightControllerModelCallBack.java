package com.flightBooking.SetupFlight;

import com.flightBooking.dto.Flight;

public interface SetupFlightControllerModelCallBack {
	public void flightAddedSuccessfully(Flight flight);
	public void flightAddingFailed(String errorMessage);
}
