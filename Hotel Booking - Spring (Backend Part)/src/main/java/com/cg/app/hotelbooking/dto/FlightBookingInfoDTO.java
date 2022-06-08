package com.cg.app.hotelbooking.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class FlightBookingInfoDTO {
	private int bookingid;
	
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
	
}
