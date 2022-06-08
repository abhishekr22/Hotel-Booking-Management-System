package com.cg.app.hotelbooking.repository;

import java.util.List;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;



public interface CustomCustomerRepository {
	public List<Flight> filterFlightByCost(String departure, String destination, double costRange1, double costRange2);
	//public String bookFlight(int flightid,int customerId);
	public List<Hotel> getHotelsByCity(String city);
	public List<Hotel> getHotelsByCost(String city, double cost1, double cost2);
}
