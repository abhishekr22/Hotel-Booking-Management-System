package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.repository.CustomerRepository;
import com.cg.app.hotelbooking.repository.IFlightRepository;
import com.cg.app.hotelbooking.repository.IHotelRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	CustomerRepository repository;
	@Autowired
	IFlightRepository flightrepository;
	@Autowired
	IHotelRepository hotelrepository;
	@Override
	public List<Flight> filterFlightByCost(String departure, String destination, double costRange1, double costRange2) {
		// TODO Auto-generated method stub
		return repository.filterFlightByCost(departure, destination, costRange1, costRange2) ;
	}
	
	@Override
	public List<Flight> getFlightByDeparture(String departure,String destination) {
		// TODO Auto-generated method stub
		return flightrepository.getFlightByDeparture(departure,destination);
	}
	@Override
	public List<Hotel> getHotelsByCity(String city) {
		// TODO Auto-generated method stub
		return repository.getHotelsByCity(city);
	}
	@Override
	public List<Hotel> getHotelsByCost(String city, double cost1, double cost2) {
		// TODO Auto-generated method stub
		return repository.getHotelsByCost(city,cost1,cost2);
	}
	
	

}
