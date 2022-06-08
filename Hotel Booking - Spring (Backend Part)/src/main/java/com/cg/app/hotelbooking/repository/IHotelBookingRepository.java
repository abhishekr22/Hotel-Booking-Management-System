package com.cg.app.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.hotelbooking.entities.HotelBooking;

public interface IHotelBookingRepository extends CrudRepository<HotelBooking, Integer>{

}
