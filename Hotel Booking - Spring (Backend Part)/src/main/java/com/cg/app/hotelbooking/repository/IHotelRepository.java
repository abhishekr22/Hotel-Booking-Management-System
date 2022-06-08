package com.cg.app.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.hotelbooking.entities.Hotel;

public interface IHotelRepository extends CrudRepository<Hotel,Integer>,CustomHotelRepository {

}
