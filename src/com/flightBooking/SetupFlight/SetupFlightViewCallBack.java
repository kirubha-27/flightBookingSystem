package com.flightBooking.SetupFlight;

import com.flightBooking.dto.Flight;

public interface SetupFlightViewCallBack {
	public void flightAddedSuccessfully(Flight flight);
	public void flightAddingFailed(String errorMessage);
}
