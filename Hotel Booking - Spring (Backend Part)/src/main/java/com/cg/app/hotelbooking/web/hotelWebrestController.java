package com.cg.app.hotelbooking.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.hotelbooking.dto.HotelBasicInfoDTO;
import com.cg.app.hotelbooking.dto.HotelSavePostDTO;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.service.CustomerService;
import com.cg.app.hotelbooking.service.IHotelService;

@RestController
@RequestMapping("/hotel")
@Validated
public class hotelWebrestController {
	@Autowired
	IHotelService service;
	@Autowired
	CustomerService custservice;
	@GetMapping("/id/{hotelId}")
	public Hotel getHotelInfo(@PathVariable int hotelId,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getHotelById(hotelId);
		}
		return null;
	}
	@GetMapping("/list")
	public List<Hotel> getHotels(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getHotels();}
		return null;
	}
	@GetMapping("/city/{city}")
	public List<Hotel> getHotelsByCity(@PathVariable String city,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return custservice.getHotelsByCity(city);
		}
		return null;
	}
	@GetMapping("/{city}/{cost1}/{cost2}")
	public List<Hotel> getHotelsByCost(@PathVariable String city,@PathVariable double cost1,@PathVariable double cost2,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return custservice.getHotelsByCost(city,cost1,cost2);
		}
		return null;
	}
	
	@PostMapping("/")
	public ResponseEntity<HotelBasicInfoDTO> saveHotel(@RequestBody @Valid HotelSavePostDTO hotel,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		HotelBasicInfoDTO dto=service.saveHotel(hotel);
		return new ResponseEntity<HotelBasicInfoDTO>(dto,HttpStatus.OK);
		}
		return null;
	}
	
	
	
}
