package com.cg.app.hotelbooking.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.hotelbooking.entities.Hotel;



@Repository
public interface CustomHotelRepository {
	public List<Hotel> getHotelsByCity(String city);
	public List<Hotel> getHotelsByCost(String city, double cost1, double cost2);
}