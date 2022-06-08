package com.cg.app.hotelbooking.service;

import java.util.List;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;


public interface CustomerService {
	public List<Flight> filterFlightByCost(String departure,String destination,double costRange1,double costRange2);
	
	public List<Flight> getFlightByDeparture(String departure,String destination);
	public List<Hotel> getHotelsByCity(String city);

	public List<Hotel> getHotelsByCost(String city, double cost1, double cost2);
//	String checkAvailability(int flightid, int customerId);
}
