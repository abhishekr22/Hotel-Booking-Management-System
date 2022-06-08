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

import com.cg.app.hotelbooking.dto.FlightBasicInfoDTO;
import com.cg.app.hotelbooking.dto.FlightSavePostDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.service.CustomerService;
import com.cg.app.hotelbooking.service.IFlightService;

@RestController
@RequestMapping("/flight")
@Validated
public class flightWebrestcontroller {
	@Autowired
	IFlightService service;
	@Autowired
	CustomerService custservice;
	@GetMapping("/id/{flightId}")
	public Flight getFlightInfo(@PathVariable int flightId,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getFlightById(flightId);
		}
		return null;
	}
	@GetMapping("/")
	public List<Flight> getAllFlight(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getAllFlights();
		}
		return null;
	}
	@PostMapping("/")
	public ResponseEntity<FlightBasicInfoDTO> saveFlight(@RequestBody @Valid FlightSavePostDTO flight,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		FlightBasicInfoDTO dto=service.saveFlight(flight);
		return new ResponseEntity<FlightBasicInfoDTO>(dto,HttpStatus.OK);
		}
		return null;
	}
	@GetMapping("/{departure}/{destination}")
	public List<Flight> getFlightByDeparture(@PathVariable String departure,@PathVariable String destination,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return custservice.getFlightByDeparture(departure,destination);
		}
		return null;
	}
	@GetMapping("/{departure}/{destination}/{cost1}/{cost2}")
	public List<Flight> getFlightsByCost(@PathVariable String departure,@PathVariable String destination,@PathVariable int cost1,@PathVariable int cost2,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return custservice.filterFlightByCost(departure, destination, cost1, cost2);
		}
		return null;
	}
	
	
}
