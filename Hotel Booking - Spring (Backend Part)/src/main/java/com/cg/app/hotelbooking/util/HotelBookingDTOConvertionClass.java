package com.cg.app.hotelbooking.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.HotelBookingInfoDTO;
import com.cg.app.hotelbooking.dto.HotelBookingSavePostDTO;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.HotelBooking;
import com.cg.app.hotelbooking.repository.IHotelRepository;

@Component
public class HotelBookingDTOConvertionClass {
	@Autowired
	IHotelRepository hotelrepository;
	@Transactional
	public HotelBooking bookHotel(HotelBookingSavePostDTO dto) {
		Hotel h=hotelrepository.findById(dto.getHotelId()).get();
		HotelBooking hb=new HotelBooking();
		hb.setBooking_id(dto.getBooking_id());
		hb.setCity(h.getCity());
		hb.setFromDate(dto.getFromDate());
		hb.setToDate(dto.getToDate());
		hb.setUser_id(dto.getUser_id());
		hb.setCost(dto.getCost());
		return hb;
	}
	public HotelBookingInfoDTO getHotelBookingBasicInfoDTO(HotelBooking savedObj) {
		HotelBookingInfoDTO dtoObj=new HotelBookingInfoDTO();
		dtoObj.setBooking_id(savedObj.getBooking_id());
		dtoObj.setCity(savedObj.getCity());
		dtoObj.setCost(savedObj.getCost());
		dtoObj.setFromDate(savedObj.getFromDate());
		dtoObj.setToDate(dtoObj.getToDate());
		dtoObj.setUser_id(savedObj.getUser_id());
		return dtoObj;
	}
}
