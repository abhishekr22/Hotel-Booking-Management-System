package com.cg.app.hotelbooking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;

@Repository
public interface CustomReviewRepository {
	public List<Review> getreviewbyflightname(String flightname);
	public List<Hotel> gethotelrangeratings(String city,int rating1, int rating2); 	
	public List<Review> getreviewbyhotelname(String hotelname);
	
	public List<Review> getreviewbyuserid(int user_id);
 
	
	public List<Hotel> sortbesthotelsbycity(String cityname);
	public List<Review> sortreviewsbyratings();


}
