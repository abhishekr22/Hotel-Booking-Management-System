package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.CustomerBasicInfoDTO;
import com.cg.app.hotelbooking.dto.CustomerSavePostDTO;
import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.repository.IAdminRepository;
import com.cg.app.hotelbooking.util.CustomerDTOConvertionClass;





@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	IAdminRepository repository;
	@Autowired
	CustomerDTOConvertionClass dtoConvertion;
	@Override
	public Passengers getCustomerInfo(int customerid) {
		// TODO Auto-generated method stub
		return repository.findById(customerid).get();
	}

	@Override
	public List<Passengers> getCustomerList() {
		// TODO Auto-generated method stub
		return (List<Passengers>) repository.findAll();
	}

	@Override
	public CustomerBasicInfoDTO saveCustomer(@Valid CustomerSavePostDTO customer) {
		// TODO Auto-generated method stub
		Passengers p=dtoConvertion.getPassengerFromPostPassengerDTO(customer);
		Passengers savedObj=repository.save(p);
		CustomerBasicInfoDTO dtoObj=dtoConvertion.getCustomerBasicInfoDTO(savedObj);
		
		return dtoObj;
	}
	/*	String qStr = "SELECT count(user) FROM User1 user1 where user1.userName like :uname and user1.password like :pwd";
				EntityManager entityManager = null;
				long list = 0L;
				try {
				entityManager = JPAUtil.getEntityManager();
				TypedQuery<Long> query = entityManager .createQuery(qStr, Long.class);
				query.setParameter("uname", userName);
				query.setParameter("pwd",passWord);
				list = query.getSingleResult();
				}catch(Exception ex) { }finally {
					if(entityManager != null) entityManager.close();
				}
				if(list==1)
					return 1;
				return list;*/

	@Override
	public boolean validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		return repository.validate(username,password);
		
	}

}
