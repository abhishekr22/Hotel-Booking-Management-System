package com.cg.app.hotelbooking.util;
import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.HotelBasicInfoDTO;
import com.cg.app.hotelbooking.dto.HotelSavePostDTO;
import com.cg.app.hotelbooking.entities.Hotel;


@Component
public class HotelDTOConvertionClass {
	public HotelBasicInfoDTO getHotelBasicInfoDTO(Hotel hotel) {
		HotelBasicInfoDTO dtoObj=new HotelBasicInfoDTO();
		dtoObj.setAddress(hotel.getAddress());
		dtoObj.setAvg_cost(hotel.getAvg_cost());
		dtoObj.setCity(hotel.getCity());
		dtoObj.setEmail(hotel.getEmail());
		dtoObj.setHotel_id(hotel.getHotel_id());
		dtoObj.setHotel_name(hotel.getHotel_name());
		dtoObj.setNo_of_rooms(hotel.getNo_of_rooms());
		//dtoObj.setPassengers(hotel.getVisitors());
		
		dtoObj.setPhone(hotel.getPhone());
		dtoObj.setWebsite(hotel.getWebsite());
		
		return dtoObj;
	}
	public Hotel getHotelFromPostHotelDTO(HotelSavePostDTO dto) {
		Hotel h=new Hotel();
		h.setAddress(dto.getAddress());
		h.setAvg_cost(dto.getAvg_cost());
		h.setCity(dto.getCity());
		h.setEmail(dto.getEmail());
		h.setHotel_id(dto.getHotel_id());
		h.setHotel_name(dto.getHotel_name());
		h.setNo_of_rooms(dto.getNo_of_rooms());
		//h.setVisitors(dto.getPassengers());
		h.setCount_of_booking(dto.getCount_of_booking());
		h.setPhone(dto.getPhone());
		h.setWebsite(dto.getWebsite());
		return h;
	}
}
