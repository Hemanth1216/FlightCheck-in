package com.hemanth.flightcheckin.integtation;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hemanth.flightcheckin.integtation.dto.Reservation;
import com.hemanth.flightcheckin.integtation.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATIION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
								 .getForObject(RESERVATIION_REST_URL+id, 
								  Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
								  .postForObject(RESERVATIION_REST_URL, request, 
								   Reservation.class);
		return reservation;
	}

}
