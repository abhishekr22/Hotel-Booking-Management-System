package com.cg.app.hotelbooking.exceptions;

public class InvalidRatingException extends Exception{
	private int rating;

	public InvalidRatingException(int rating) {
		// TODO Auto-generated constructor stub
		super();
		this.rating=rating;
	}
	@Override
	public String toString() {
		return "InvalidRating [Rating=" + rating + "]"+ "\n\n Enter rating in range of 1-5";
		
	}
	

}
