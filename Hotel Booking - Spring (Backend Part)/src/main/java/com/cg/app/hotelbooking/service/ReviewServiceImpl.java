package com.cg.app.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.ReviewBasicInfoDTO;
import com.cg.app.hotelbooking.dto.ReviewSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;
import com.cg.app.hotelbooking.repository.IFlightRepository;
import com.cg.app.hotelbooking.repository.IHotelRepository;
import com.cg.app.hotelbooking.repository.IReviewRepository;
import com.cg.app.hotelbooking.util.ReviewDTOConvertionClass;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	IReviewRepository repository;
	@Autowired
	ReviewDTOConvertionClass dtoConvertion;
	@Autowired
	IHotelRepository hotelrepository;
	@Autowired
	IReviewRepository reviewrepository;
	@Autowired
	IFlightRepository flightrepository;
	@Override
	public List<Review> getallreviews() {
	     List<Review> list = (List<Review>) repository.findAll();
	     return list;

	}
	@Override
	public List<Hotel> sorthotelbycity(String cityname) {
		//List<Hotel> hotels=hotelrepository.
	//	List<Hotel> hotels=hotelrepository.getHotelsByCity(cityname);
		
		
		return repository.sortbesthotelsbycity(cityname);
	}

	@Override
	public List<Review> getreviewbyhotelname(String hotelname) {
		return repository.getreviewbyhotelname(hotelname);
	}

	@Override
	public List<Review> getreviewbyflightname(String flightname) {
		return repository.getreviewbyflightname(flightname);
	}

	@Override
	public List<Hotel> gethotelrangeratings(String cityname, int rating1, int rating2) {
		return repository.gethotelrangeratings(cityname, rating1, rating2);
	}


	
	@Override
	public boolean deletebyreviewid(int review_id) {
		repository.deleteById(review_id);
		return true;
	}

	@Override
	public Review getreviewbyreviewid(int review_id) {
		return repository.findById(review_id).get();
	}

	@Override
	public List<Review> getreviewbyuserid(int user_id) {
		// TODO Auto-generated method stub
		return repository.getreviewbyuserid(user_id);
	}

	

	@Override
	public ReviewBasicInfoDTO saveReview(@Valid ReviewSavePostDTO review) {
		// TODO Auto-generated method stub
		Review r=dtoConvertion.getReviewFromPostDTO(review);
		Review savedObj=repository.save(r);
		ReviewBasicInfoDTO dtoObj=dtoConvertion.getReviewBasicInfoDTO(savedObj);
		return dtoObj;
	}



	@Override
	@Transactional
	public String addReview(int hotelid, int review_id) {
		// TODO Auto-generated method stub
		Hotel h=hotelrepository.findById(hotelid).get();
		Review r=reviewrepository.findById(review_id).get();
		List<Review> reviews=h.getRating();
		reviews.add(r);
		h.setRating(reviews);
		hotelrepository.save(h);
		return "review added";
	}



	@Override
	public String avgRating(int flightid) {
		// TODO Auto-generated method stub
		Flight f=flightrepository.findById(flightid).get();
		String name = f.getFlight_name();	
		List<Review> reviews=f.getReviews();
		double avg=reviews.stream().mapToDouble(Review::getRating).average().getAsDouble();
		return name+" "+avg;
	}
	@Override
	public List<Flight> getflightrangeratings(String destination, String departure, int rating1, int rating2) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Review> sortreviewsbyratings() {
		// TODO Auto-generated method stub
		return repository.sortreviewsbyratings();
	}


	
	
}
