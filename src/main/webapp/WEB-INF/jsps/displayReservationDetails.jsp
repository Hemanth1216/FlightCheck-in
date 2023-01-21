<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Details</title>
</head>
<body>
	<h2>Flight Details : </h2>
	Flight No. : ${reservation.flight.flightNumber} <br/>
	Airlines : ${reservation.flight.operatingAirlines}<br/>
	Departure City : ${reservation.flight.departureCity}<br/>
	Arrival City : ${reservation.flight.arrivalCity}<br/>
	Date Of Departure : ${reservation.flight.dateOfDeparture}<br/>
	Estimated Time : ${reservation.flight.estimatedDepartureTime}<br/>
	
	<h2>Passenger Details</h2>
	Passenger FirstName : ${reservation.passenger.firstName}<br/>
	Passenger LastName : ${reservation.passenger.lastName}<br/>
	Passenger Email Id : ${reservation.passenger.email}<br/>
	Passenger PhoneNumber : ${reservation.passenger.phone}<br/>
	
	<form action="completeCheckin" method="post">
		<pre>
			Enter Number of Bags you want to check in : <input type="text" name="noOfBags"/>
			<input type="hidden" value="${reservation.id}" name="reservationId"/>
			<input type="submit" value="checkin"/>
		</pre>
	</form>
</body>
</html>