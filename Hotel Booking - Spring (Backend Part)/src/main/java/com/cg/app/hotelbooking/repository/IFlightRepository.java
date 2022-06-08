package com.cg.app.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.hotelbooking.entities.Flight;


public interface IFlightRepository extends CrudRepository<Flight,Integer>,CustomFlightRepository {

}
