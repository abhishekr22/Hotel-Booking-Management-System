package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.HotelBasicInfoDTO;
import com.cg.app.hotelbooking.dto.HotelSavePostDTO;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;
import com.cg.app.hotelbooking.repository.CustomerRepository;
import com.cg.app.hotelbooking.repository.IHotelRepository;
import com.cg.app.hotelbooking.util.HotelDTOConvertionClass;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	IHotelRepository repository;
	@Autowired
	CustomerRepository custrepository;
	@Autowired
	HotelDTOConvertionClass dtoConvertion;
	@Override
	public Hotel getHotelById(int hotelId) {
		// TODO Auto-generated method stub
		return repository.findById(hotelId).get();
	}
	@Override
	public List<Hotel> getHotels() {
		// TODO Auto-generated method stub
		return (List<Hotel>) repository.findAll();
	}
	@Override
	public HotelBasicInfoDTO saveHotel(@Valid HotelSavePostDTO hotelDTO) {
		// TODO Auto-generated method stub
		Hotel h=dtoConvertion.getHotelFromPostHotelDTO(hotelDTO);
		Hotel savedObj=repository.save(h);
		HotelBasicInfoDTO dtoObj=dtoConvertion.getHotelBasicInfoDTO(savedObj);
		
		return dtoObj;
	}
	@Override
	public String avgRating(int hotelid) {
		// TODO Auto-generated method stub
		Hotel h=repository.findById(hotelid).get();
		String hname=h.getHotel_name();
		List<Review> reviews=h.getRating();
		double avg=reviews.stream().mapToDouble(Review::getRating).average().getAsDouble();
		return hname+" "+avg;
	}
	
	
	

	

}