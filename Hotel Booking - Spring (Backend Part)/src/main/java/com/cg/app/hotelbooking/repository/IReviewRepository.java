package com.cg.app.hotelbooking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;


public interface IReviewRepository extends CrudRepository<Review,Integer>, CustomReviewRepository {



}
