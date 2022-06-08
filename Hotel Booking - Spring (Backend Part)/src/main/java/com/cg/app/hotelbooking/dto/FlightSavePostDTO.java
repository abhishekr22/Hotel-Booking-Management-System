package com.cg.app.hotelbooking.dto;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.entities.Review;


public class FlightSavePostDTO {
	@Id
	@NotNull(message="flight id cannot be null")
	private int flight_id;
	private String flight_name;
	private double avg_rate;
	@Email
	private String email;
	@Size(min=10,max=10)
	private String phone1;
	
	private String website;
	private String destination;
	private String departure;
	
	private int flightcapacity;

	private int count_of_booking;

	private List<Review> reviews;

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public double getAvg_rate() {
		return avg_rate;
	}

	public void setAvg_rate(double avg_rate) {
		this.avg_rate = avg_rate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getFlightcapacity() {
		return flightcapacity;
	}

	public void setFlightcapacity(int flightcapacity) {
		this.flightcapacity = flightcapacity;
	}

	
	public int getCount_of_booking() {
		return count_of_booking;
	}

	public void setCount_of_booking(int count_of_booking) {
		this.count_of_booking = count_of_booking;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public FlightSavePostDTO(@NotNull(message = "flight id cannot be null") int flight_id, String flight_name,
			double avg_rate, @Email String email, @Size(min = 10, max = 10) String phone1, String website,
			String destination, String departure, int flightcapacity, int count_of_booking, List<Review> reviews) {
		super();
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.avg_rate = avg_rate;
		this.email = email;
		this.phone1 = phone1;
		this.website = website;
		this.destination = destination;
		this.departure = departure;
		this.flightcapacity = flightcapacity;
		this.count_of_booking = count_of_booking;
		this.reviews = reviews;
	}

	
	
	
}
