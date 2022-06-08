package com.cg.app.hotelbooking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.spi.QueryParameterBindingTypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;

@Service
public class CustomReviewRepositoryImpl implements CustomReviewRepository{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Review> getreviewbyflightname(String flightname) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Review r,Flight f where f.flight_id=r.service_id and f.flight_name=:flightname";
		Query<Review> query = session.createQuery(queryString);
		query.setString("flightname", flightname);
		List<Review>  list = query.getResultList();
		return list;
	}
	
	@Override
	public List<Hotel> sortbesthotelsbycity(String cityname) {
	Session session = entityManager.unwrap(Session.class);
		String queryString = "from Hotel h where h.city=:cityname";
		Query<Hotel> query = session.createQuery(queryString);
		query.setString("cityname", cityname);
		List<Hotel>  list = (List<Hotel>) query.getResultList();
		return list;
		
	}

	@Override
	public List<Hotel> gethotelrangeratings(String cityname, int rating1, int rating2) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Hotel h,Review r where h.city=:cityname and r.rating>=:rating1 and r.rating<=:rating2";
		Query<Hotel> query = session.createQuery(queryString);
		query.setString("cityname", cityname);
		query.setInteger("rating1", rating1);
		query.setInteger("rating2", rating2);
		List<Hotel>  list = (List<Hotel>) query.getResultList();
		return list;
	}


	@Override
	public List<Review> getreviewbyhotelname(String hotelname) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Review r where r.hotelname=:hotelname";
		Query<Review> query = session.createQuery(queryString);
		query.setString("hotelname", hotelname);
		List<Review>  list = (List<Review>)query.getResultList();
		return list;
	}


	@Override
	public List<Review> getreviewbyuserid(int user_id) {
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Review r where r.user_id=:user_id";
		Query<Review> query = session.createQuery(queryString);
		query.setInteger("user_id", user_id);
		List<Review>  list = (List<Review>)query.getResultList();
		return list;
		
	}

	@Override
	public List<Review> sortreviewsbyratings() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		String queryString = "from Review r order by r.rating";
		Query<Review> query = session.createQuery(queryString);
		List<Review>  list = (List<Review>)query.getResultList();
		return list;
	}

	



}
