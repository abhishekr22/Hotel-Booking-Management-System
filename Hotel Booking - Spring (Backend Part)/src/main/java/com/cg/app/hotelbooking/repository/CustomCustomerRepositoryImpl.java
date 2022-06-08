package com.cg.app.hotelbooking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;



public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {
	@Autowired
	EntityManager emanager;
	@Override
	public List<Flight> filterFlightByCost(String departure, String destination, double costRange1, double costRange2) {
		Session session = emanager.unwrap(Session.class);
		// select * from AccountTable where cityName = 'dffd';
		String queryString = "from Flight f where f.departure=:cityName and f.destination=:dest and f.avg_rate>=:c1 and avg_rate<=:c2";
		
		Query<Flight> query = session.createQuery(queryString);
		query.setString("cityName",departure);
		query.setString("dest",destination);
		query.setDouble("c1", costRange1);
		query.setDouble("c2", costRange2);
		List<Flight>  list = (List<Flight>) query.getResultList();
		
		if(list != null)
		{
			return list;
		}
		else
		{
			throw new javax.persistence.NoResultException("City Name Records Not In The DB");
		}
	}
	
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