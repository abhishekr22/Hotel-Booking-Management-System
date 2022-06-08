package com.cg.app.hotelbooking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Passengers;

public class CustomAdminRepoImpl implements CustomAdminRepo {
	@Autowired
	EntityManager emanager;
	@Override
	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		Session session=emanager.unwrap(Session.class);
		String qstr="from Passengers p where p.user_name=:qname and p.password=:qpass ";
		Query<Passengers> query=session.createQuery(qstr);
		query.setString("qname", username);
		query.setString("qpass", password);
		List<Passengers> list=(List<Passengers>)query.getResultList();
	//	System.out.println(list.size());
		if(list.size()==1)
			return true;
		return false;
		
	}

}
