package com.cg.app.hotelbooking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Passengers;



public class CustomFlightRepositoryImpl implements CustomFlightRepository {
	@Autowired
	EntityManager entityManager; 
	@Override
	public List<Flight> getFlightByDeparture(String departure,String destination) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		String str="from Flight f where f.departure=:qstatus and f.destination=:qdestination";
		Query<Flight> query=session.createQuery(str);
		query.setString("qstatus",departure);
		query.setString("qdestination",destination);
		
		List<Flight> list=(List<Flight>)query.getResultList();
		if(list!=null)
			return list;
		else 
			throw  new javax.persistence.NoResultException("no flight records in the db with rating");
	}
	
	
	
	

}
