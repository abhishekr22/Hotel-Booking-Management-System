package com.cg.app.hotelbooking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Passengers;

@Repository
public interface CustomFlightRepository {
	public List<Flight> getFlightByDeparture(String departure,String destination);
	
	
	
}
