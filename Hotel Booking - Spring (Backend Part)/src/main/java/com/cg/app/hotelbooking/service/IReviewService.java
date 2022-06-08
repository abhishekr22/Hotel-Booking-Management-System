package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.ReviewBasicInfoDTO;
import com.cg.app.hotelbooking.dto.ReviewSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;

public interface IReviewService {
	

	public List<Review> getreviewbyuserid(int user_id);

	public List<Review> getallreviews();
	public ReviewBasicInfoDTO saveReview(@Valid ReviewSavePostDTO review);
	
	public List<Hotel> sorthotelbycity(String cityname);
	
	public List<Review> getreviewbyhotelname(String hotelname);
	public List<Review> getreviewbyflightname(String flightname);

	public List<Hotel> gethotelrangeratings(String cityname,int rating1, int rating2); 	
	public List<Flight> getflightrangeratings(String destination,String departure,int rating1, int rating2); 
	
	public boolean deletebyreviewid(int review_id);
	public Review getreviewbyreviewid(int review_id);
	public String addReview(int hotelid, int review_id);
	public String avgRating(int flightid);

	public List<Review> sortreviewsbyratings();
}
