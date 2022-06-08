package com.cg.app.hotelbooking.util;

import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.FlightBasicInfoDTO;
import com.cg.app.hotelbooking.dto.FlightSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;

@Component
public class FlightDTOConvertionClass {
	public FlightBasicInfoDTO getFlightBasicInfoDTO(Flight flight) {
		FlightBasicInfoDTO dtoObj=new FlightBasicInfoDTO();
		dtoObj.setAvg_rate(flight.getAvg_rate());
		dtoObj.setCount_of_booking(flight.getCount_of_booking());;
		dtoObj.setDeparture(flight.getDeparture());
		dtoObj.setDestination(flight.getDestination());
		dtoObj.setEmail(flight.getEmail());
		dtoObj.setFlight_id(flight.getFlight_id());
		dtoObj.setFlight_name(flight.getFlight_name());
		dtoObj.setFlightcapacity(flight.getFlightcapacity());
		dtoObj.setPhone1(flight.getPhone1());
		dtoObj.setReviews(flight.getReviews());
		dtoObj.setWebsite(flight.getWebsite());
		return dtoObj;
	}
	public Flight getFlightFromPostFlightDTO(FlightSavePostDTO dto) {
		Flight  f=new Flight();
		f.setAvg_rate(dto.getAvg_rate());
		f.setCount_of_booking(dto.getCount_of_booking());
		f.setDeparture(dto.getDeparture());
		f.setDestination(dto.getDestination());
		f.setEmail(dto.getEmail());
		f.setFlight_id(dto.getFlight_id());
		f.setFlight_name(dto.getFlight_name());
		f.setFlightcapacity(dto.getFlightcapacity());
		f.setPhone1(dto.getPhone1());
		f.setReviews(dto.getReviews());
		f.setWebsite(dto.getWebsite());
		return f;
	}
}
