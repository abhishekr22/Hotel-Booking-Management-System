package com.cg.app.hotelbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.FlightBookingInfoDTO;
import com.cg.app.hotelbooking.dto.FlightBookingSavePostDTO;
import com.cg.app.hotelbooking.dto.HotelBookingInfoDTO;
import com.cg.app.hotelbooking.dto.HotelBookingSavePostDTO;
import com.cg.app.hotelbooking.entities.FlightBooking;
@Service
public interface IBookingService {
	public FlightBookingInfoDTO saveFlightBooking(FlightBookingSavePostDTO fbdto);
	public HotelBookingInfoDTO saveHotelBooking(HotelBookingSavePostDTO hbdto);
	public List<FlightBooking> getAllFlightBooking();
	public boolean checkFlightAvailability(int flightid);
	public boolean cancleFlight(int flightid,int customerId);
	public boolean checkHotelAvailabilty(int hotelid);
	public boolean cancleHotel(int hotelid,int customerId);
}
