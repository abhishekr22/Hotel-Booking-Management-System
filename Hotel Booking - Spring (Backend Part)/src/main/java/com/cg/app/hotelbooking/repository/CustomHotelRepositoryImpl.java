package com.cg.app.hotelbooking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.app.hotelbooking.entities.Hotel;

public class CustomHotelRepositoryImpl implements CustomHotelRepository {
	@Autowired
	EntityManager emanager;
	@Override
	public List<Hotel> getHotelsByCity(String city) {
		// TODO Auto-generated method stub
		Session session=emanager.unwrap(Session.class);
		String str="from Hotel h where h.city=:qstatus";
		Query<Hotel> query=session.createQuery(str);
		query.setString("qstatus",city);
		
		List<Hotel> list=(List<Hotel>)query.getResultList();
		if(list!=null)
			return list;
		else 
			throw  new javax.persistence.NoResultException("no flight records in the db with rating");
	}
	@Override
	public List<Hotel> getHotelsByCost(String city, double cost1, double cost2) {
		// TODO Auto-generated method stub
		Session session=emanager.unwrap(Session.class);
		String str="from Hotel h where h.city=:qstatus and h.avg_cost>=:qcost1 and h.avg_cost<=:qcost2";
		Query<Hotel> query=session.createQuery(str);
		query.setString("qstatus",city);
		query.setDouble("qcost1", cost1);
		query.setDouble("qcost2", cost2);
		
		List<Hotel> list=(List<Hotel>)query.getResultList();
		if(list!=null)
			return list;
		else 
			throw  new javax.persistence.NoResultException("no flight records in the db with rating");
		
	}

}
