package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.FlightBasicInfoDTO;
import com.cg.app.hotelbooking.dto.FlightSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Review;
import com.cg.app.hotelbooking.repository.IFlightRepository;
import com.cg.app.hotelbooking.repository.IReviewRepository;
import com.cg.app.hotelbooking.util.FlightDTOConvertionClass;


@Service
public class FlightServiceImpl implements IFlightService {
	@Autowired
	IFlightRepository repository;
	@Autowired
	FlightDTOConvertionClass dtoConvertion;
	@Autowired
	IReviewRepository reviewrepo;
	@Override
	public Flight getFlightById(int flightId) {
		// TODO Auto-generated method stub
		return repository.findById(flightId).get();
	}
	
	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return (List<Flight>) repository.findAll();
	}

	@Override
	public FlightBasicInfoDTO saveFlight(@Valid FlightSavePostDTO flightDTO) {
		// TODO Auto-generated method stub
		Flight f=dtoConvertion.getFlightFromPostFlightDTO(flightDTO);
		Flight savedObj=repository.save(f);
		FlightBasicInfoDTO dtoObj=dtoConvertion.getFlightBasicInfoDTO(savedObj);
		
		return dtoObj;
	}

	@Override
	@Transactional
	public String addReview(int flightid, int review_id) {
		// TODO Auto-generated method stub
		Review r=reviewrepo.findById(review_id).get();
		Flight f=repository.findById(flightid).get();
		List<Review> reviews=f.getReviews();
		reviews.add(r);
		f.setReviews(reviews);
		repository.save(f);
				
		return "review added";
	}

}
