package com.cg.app.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.hotelbooking.entities.Passengers;

public interface IAdminRepository extends CrudRepository<Passengers,Integer>,CustomAdminRepo {

	

}
