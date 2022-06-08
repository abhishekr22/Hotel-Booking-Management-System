package com.cg.app.hotelbooking.util;
import org.springframework.stereotype.Component;

import com.cg.app.hotelbooking.dto.CustomerBasicInfoDTO;
import com.cg.app.hotelbooking.dto.CustomerSavePostDTO;
import com.cg.app.hotelbooking.entities.Passengers;



@Component
public class CustomerDTOConvertionClass {
	public CustomerBasicInfoDTO getCustomerBasicInfoDTO(Passengers passengers) {
		CustomerBasicInfoDTO dtoObj=new CustomerBasicInfoDTO();
		dtoObj.setAddress(passengers.getAddress());
		dtoObj.setEmail(passengers.getEmail());
		dtoObj.setMobile(passengers.getMobile());
		dtoObj.setPassword(passengers.getPassword());
		dtoObj.setUser_id(passengers.getUser_id());
		dtoObj.setUser_name(passengers.getUser_name());
		return dtoObj;
	}
	public Passengers getPassengerFromPostPassengerDTO(CustomerSavePostDTO dto) {
		Passengers p=new Passengers();
		p.setAddress(dto.getAddress());
		p.setEmail(dto.getEmail());
		p.setMobile(dto.getMobile());
		p.setPassword(dto.getPassword());
		p.setUser_id(dto.getUser_id());
		p.setUser_name(dto.getUser_name());
		return p;
	}
}
