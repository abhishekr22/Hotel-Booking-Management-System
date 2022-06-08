package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.HotelBasicInfoDTO;
import com.cg.app.hotelbooking.dto.HotelSavePostDTO;
import com.cg.app.hotelbooking.entities.Hotel;


@Service
public interface IHotelService {
	public Hotel getHotelById(int hotelId);

	public List<Hotel> getHotels();

	public HotelBasicInfoDTO saveHotel(@Valid HotelSavePostDTO hotel);

	public String avgRating(int hotelid);

	


}