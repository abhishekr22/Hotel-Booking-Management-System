package com.cg.app.hotelbooking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.app.hotelbooking.dto.CustomerBasicInfoDTO;
import com.cg.app.hotelbooking.dto.CustomerSavePostDTO;
import com.cg.app.hotelbooking.entities.Passengers;



@Service
public interface IAdminService {

	Passengers getCustomerInfo(int customerid);

	List<Passengers> getCustomerList();

	CustomerBasicInfoDTO saveCustomer(@Valid CustomerSavePostDTO customer);

	boolean validateLogin(String username, String password);

}
