package com.hemanth.flightcheckin.integtation;

import com.hemanth.flightcheckin.integtation.dto.Reservation;
import com.hemanth.flightcheckin.integtation.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
