package com.hemanth.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemanth.flightcheckin.integtation.ReservationRestClient;
import com.hemanth.flightcheckin.integtation.dto.Reservation;
import com.hemanth.flightcheckin.integtation.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {

	@Autowired
	ReservationRestClient reservationRestClient;
	
	
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}
	
	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long id,ModelMap model) {
		Reservation reservation = reservationRestClient.findReservation(id);
		model.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("/completeCheckin")
	public String completeCheckin(@RequestParam("reservationId") Long id,
									@RequestParam("noOfBags") int noOfBags) {
		
		ReservationUpdateRequest updateRequest = new ReservationUpdateRequest();
		updateRequest.setId(id);
		updateRequest.setCheckedIn(true);
		updateRequest.setNumberOfBags(noOfBags);
		reservationRestClient.updateReservation(updateRequest);
		return "checkinConfirmation";
		
	}
}
