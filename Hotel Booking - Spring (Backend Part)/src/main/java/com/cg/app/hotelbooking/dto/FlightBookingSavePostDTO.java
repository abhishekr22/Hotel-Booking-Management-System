package com.cg.app.hotelbooking.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class FlightBookingSavePostDTO {
	private int bookingid;
	@NotNull(message="flightid cannot be null")
	private int flightId;
	private String departure;
	private String destination;
	private Date onDate;
	private double cost;
	private int user_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getOnDate() {
		return onDate;
	}
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public FlightBookingSavePostDTO(int bookingid, @NotNull(message = "flightid cannot be null") int flightId,
			String departure, String destination, Date onDate, double cost) {
		super();
		this.bookingid = bookingid;
		this.flightId = flightId;
		this.departure = departure;
		this.destination = destination;
		this.onDate = onDate;
		this.cost = cost;
	}
	public FlightBookingSavePostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
