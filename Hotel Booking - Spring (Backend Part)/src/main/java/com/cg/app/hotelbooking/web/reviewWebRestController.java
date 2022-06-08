package com.cg.app.hotelbooking.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.hotelbooking.service.IAdminService;
import com.cg.app.hotelbooking.service.IFlightService;
import com.cg.app.hotelbooking.service.IHotelService;
import com.cg.app.hotelbooking.service.IReviewService;
import com.cg.app.hotelbooking.dto.ReviewBasicInfoDTO;
import com.cg.app.hotelbooking.dto.ReviewSavePostDTO;
import com.cg.app.hotelbooking.entities.*;

@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:4200"},allowedHeaders = "*")
@RequestMapping("/review")
@RestController
public class reviewWebRestController {
	@Autowired IAdminService servicead;
	@Autowired IReviewService service;
	@Autowired IFlightService flightservice;
	@Autowired
	IHotelService hotelservice;
	@GetMapping("/")
	public String welcomepage() {
		return "<h1> Welcome To Review's Module</h1>"; 
	}
	@GetMapping("/allreviews")
	public List<Review> getallreviews(){

		return service.getallreviews();


	}
	@PostMapping("/savereview")
	public ResponseEntity<ReviewBasicInfoDTO> savereview(@Valid @RequestBody ReviewSavePostDTO review) {

		ReviewBasicInfoDTO dto=service.saveReview(review);
		return new ResponseEntity<ReviewBasicInfoDTO>(dto,HttpStatus.OK);

	}
	@GetMapping("/fname/{flight_name}")
	public List<Review> getreviewflightsbyname(@PathVariable String flight_name){
		return service.getreviewbyflightname(flight_name);
	}
	
	@GetMapping("/hname/{city}/{rating1}/{rating2}")
	public List<Hotel> gethotelreviewbycityrange(@PathVariable String city,@PathVariable int rating1,@PathVariable int rating2){
		return service.gethotelrangeratings(city, rating1, rating2);
	}
	
	@DeleteMapping("/deletereview/{review_id}")
	public boolean deletebyreviewid(@PathVariable int review_id) {

		return service.deletebyreviewid(review_id);

	}
	
	@GetMapping("/get/{review_id}")
	public Review getbyreviewid(@PathVariable int review_id) {

		return service.getreviewbyreviewid(review_id);

	}
	
	@GetMapping("/getuser/{user_id}")
	public List<Review> getreviewbyuserid(@PathVariable int user_id){

		return service.getreviewbyuserid(user_id);
	}
	
	
	
	@GetMapping("/cityreview/{city}")
	public List<Hotel> sorthotelbycity(@PathVariable String city){

		return service.sorthotelbycity(city);

	}
	
	@GetMapping("/hotel/{hotel_name}")
	public List<Review> getreviewbyhotelname(@PathVariable String hotel_name){
	
		return service.getreviewbyhotelname(hotel_name);

	}
	
	@GetMapping("/hadd/{hotel_id}/{review_id}")
	public String addReview(@PathVariable int hotel_id,@PathVariable int review_id)
	{

		return service.addReview(hotel_id,review_id);

	}
	@GetMapping("/fadd/{flight_id}/{review_id}")
	public String addFlightReview(@PathVariable int flight_id,@PathVariable int review_id) {

		return flightservice.addReview(flight_id,review_id);

	}
	@GetMapping("/avg/{flight_id}")
	public String getAvgRatingOfFlight(@PathVariable int flight_id) {

		return service.avgRating(flight_id);
	}
	@GetMapping("/havg/{hotel_id}")
	public String getAvgRatingOfHotel(@PathVariable int hotel_id) {

		return hotelservice.avgRating(hotel_id);
	}
	@GetMapping("/allreviews/sortrating")
	public List<Review> sortreviewsbyratings(){
		return service.sortreviewsbyratings();
	}
	
	
}
