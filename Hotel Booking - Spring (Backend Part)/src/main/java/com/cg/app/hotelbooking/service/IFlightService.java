package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.FlightBasicInfoDTO;
import com.cg.app.hotelbooking.dto.FlightSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;



@Service
public interface IFlightService {
	public Flight getFlightById(int flightId);
	public FlightBasicInfoDTO saveFlight(@Valid FlightSavePostDTO flight);
	

	public List<Flight> getAllFlights();
	public String addReview(int flightid, int review_id);
}
