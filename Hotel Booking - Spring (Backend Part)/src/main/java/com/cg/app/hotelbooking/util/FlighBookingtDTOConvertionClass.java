package com.cg.app.hotelbooking.util;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.FlightBookingInfoDTO;
import com.cg.app.hotelbooking.dto.FlightBookingSavePostDTO;
import com.cg.app.hotelbooking.dto.FlightSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.FlightBooking;
import com.cg.app.hotelbooking.repository.IFlightRepository;

@Component
public class FlighBookingtDTOConvertionClass {
	@Autowired
	IFlightRepository flightrepository;
	@Transactional
	public FlightBooking bookFlight(FlightBookingSavePostDTO dto) {
		Flight f=flightrepository.findById(dto.getFlightId()).get();
		FlightBooking fb=new FlightBooking();
		fb.setBookingid(dto.getBookingid());
		fb.setCost(f.getAvg_rate());
		fb.setDeparture(f.getDeparture());
		fb.setDestination(f.getDestination());
		fb.setFlightId(dto.getFlightId());
		fb.setOnDate(dto.getOnDate());
		fb.setUser_id(dto.getUser_id());
		return fb;
	}
	public FlightBookingInfoDTO getFlightBookingBasicInfoDTO(FlightBooking savedObj) {
		FlightBookingInfoDTO dtoObj=new FlightBookingInfoDTO();
		dtoObj.setBookingid(savedObj.getBookingid());
		dtoObj.setDeparture(savedObj.getDeparture());
		dtoObj.setDestination(savedObj.getDestination());
		dtoObj.setFlightId(savedObj.getFlightId());
		dtoObj.setOnDate(savedObj.getOnDate());
		dtoObj.setCost(savedObj.getCost());
		dtoObj.setUser_id(savedObj.getUser_id());
		return dtoObj;
	}
}
