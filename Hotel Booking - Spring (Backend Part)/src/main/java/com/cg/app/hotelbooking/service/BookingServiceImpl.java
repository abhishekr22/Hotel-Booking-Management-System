package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.FlightBasicInfoDTO;
import com.cg.app.hotelbooking.dto.FlightBookingInfoDTO;
import com.cg.app.hotelbooking.dto.FlightBookingSavePostDTO;
import com.cg.app.hotelbooking.dto.HotelBookingInfoDTO;
import com.cg.app.hotelbooking.dto.HotelBookingSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.FlightBooking;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.HotelBooking;
import com.cg.app.hotelbooking.repository.IFlightBookingRepository;
import com.cg.app.hotelbooking.repository.IFlightRepository;
import com.cg.app.hotelbooking.repository.IHotelBookingRepository;
import com.cg.app.hotelbooking.repository.IHotelRepository;
import com.cg.app.hotelbooking.util.FlighBookingtDTOConvertionClass;
import com.cg.app.hotelbooking.util.HotelBookingDTOConvertionClass;
@Service
public class BookingServiceImpl implements IBookingService {
	@Autowired
	FlighBookingtDTOConvertionClass dtoConvertion;
	@Autowired
	HotelBookingDTOConvertionClass hotelConvertion;
	@Autowired
	IFlightRepository flightrepository;
	@Autowired
	IHotelRepository hotelrepository;
	@Autowired
	IFlightBookingRepository repository;
	@Autowired
	IFlightBookingRepository bookrepo;
	@Autowired
	IHotelBookingRepository hotelbook;
	@Override
	public FlightBookingInfoDTO saveFlightBooking(FlightBookingSavePostDTO fbdto) {
		// TODO Auto-generated method stub
		if(checkFlightAvailability(fbdto.getFlightId())) {
			FlightBooking flight=dtoConvertion.bookFlight(fbdto);
			FlightBooking savedObj=bookrepo.save(flight);
			FlightBookingInfoDTO dtoObj=dtoConvertion.getFlightBookingBasicInfoDTO(savedObj);
			return dtoObj;
			
		}
		return null;
	}
	@Override
	public HotelBookingInfoDTO saveHotelBooking(HotelBookingSavePostDTO hbdto) {
		// TODO Auto-generated method stub
		if(checkHotelAvailabilty(hbdto.getHotelId())) {
			HotelBooking hotel=hotelConvertion.bookHotel(hbdto);
			HotelBooking savedObj=hotelbook.save(hotel);
			HotelBookingInfoDTO dtoObj=hotelConvertion.getHotelBookingBasicInfoDTO(savedObj);
			return dtoObj;
		}
		return null;
	}
	@Override
	public List<FlightBooking> getAllFlightBooking() {
		// TODO Auto-generated method stub
		return (List<FlightBooking>) repository.findAll();
	}
	@Override
	@Transactional
	public boolean cancleFlight(int flightid, int customerId) {
		// TODO Auto-generated method stub
		Flight f=flightrepository.findById(flightid).get();
		f.setCount_of_booking(f.getCount_of_booking()-1);
		flightrepository.save(f);
		
		return true;
	}

	@Override
	@Transactional
	public boolean checkFlightAvailability(int flightid) {
		// TODO Auto-generated method stub
		Flight f=flightrepository.findById(flightid).get();
	//	Passengers p=repository.findById(customerId).get();
		
		if(f.getCount_of_booking()<f.getFlightcapacity()) {
			f.setCount_of_booking(f.getCount_of_booking()+1);
			flightrepository.save(f);
			return true;
		}
		return false;
		
	}

	

	@Override
	@Transactional
	public boolean checkHotelAvailabilty(int hotelid) {
		// TODO Auto-generated method stub
		Hotel h=hotelrepository.findById(hotelid).get();
		/*Passengers p=repository.findById(customerId).get();
		if(h.getVisitors().size()<h.getNo_of_rooms()) {
			List<Passengers> passengers=h.getVisitors();
			passengers.add(p);
			h.setVisitors(passengers);
			hotelrepository.save(h);
			return "booked successfully";
		}
		return "not booked";*/
		if(h.getCount_of_booking()<h.getNo_of_rooms()) {
			h.setCount_of_booking(h.getCount_of_booking()+1);
			hotelrepository.save(h);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean cancleHotel(int hotelid, int customerId) {
		// TODO Auto-generated method stub
		Hotel h=hotelrepository.findById(hotelid).get();
		/*Passengers p=repository.findById(customerId).get();
		List<Passengers> passengers=h.getVisitors();
		if(passengers.contains(p)) {
			passengers.remove(p);
			h.setVisitors(passengers);
			hotelrepository.save(h);
			return "cancled booking successfully";
		}
		return "not booked yet";*/
		h.setCount_of_booking(h.getCount_of_booking()-1);
		hotelrepository.save(h);
		return true;
	
	}
	

}
