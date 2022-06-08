
package com.cg.app.hotelbooking.web;

import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.hotelbooking.dto.CustomerBasicInfoDTO;
import com.cg.app.hotelbooking.dto.CustomerSavePostDTO;
import com.cg.app.hotelbooking.dto.FlightBookingInfoDTO;
import com.cg.app.hotelbooking.dto.FlightBookingSavePostDTO;
import com.cg.app.hotelbooking.dto.HotelBookingInfoDTO;
import com.cg.app.hotelbooking.dto.HotelBookingSavePostDTO;
import com.cg.app.hotelbooking.dto.UserDTO;
import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.FlightBooking;
import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.repository.IFlightBookingRepository;
import com.cg.app.hotelbooking.service.IAdminService;
import com.cg.app.hotelbooking.service.IBookingService;
import com.cg.app.hotelbooking.service.IFlightService;

@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:4200"},allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
@Validated
public class CustomerWebRestController {
	@Autowired
	IAdminService service;
	@Autowired
	IBookingService bookservice;
	@Autowired
	IFlightService flightservice;
	
	@PostMapping("/login")
	public boolean doLogin(@RequestBody UserDTO userDto,HttpServletRequest request) {

		boolean isUserValidated=false;
		if(service.validateLogin(userDto.getUsername(),userDto.getPassword())) {
		
			isUserValidated=true;
			HttpSession session=request.getSession(true);
			session.setAttribute("username",userDto.getUsername());
			session.setAttribute("loginTime", LocalTime.now());
			
		}
		return isUserValidated;
	}
	@GetMapping("/logout")
	public String doLogout(HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		
		if(session!=null) {
			session.invalidate();
		}
		return "session logout";
	}
	@GetMapping("/{customerid}") 
	public Passengers getCustomerInfo(@PathVariable int customerid,HttpServletRequest req)  {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return service.getCustomerInfo(customerid);
		}
		return null;
	}
	@GetMapping("/")
	public List<Passengers> getCustomerList(){

		return service.getCustomerList();

		
	}
	@PostMapping("/save")
	public ResponseEntity<CustomerBasicInfoDTO> saveCustomer(@RequestBody CustomerSavePostDTO customer){
	/*	HttpSession session=req.getSession(false);
		if(session!=null) {
		*/
		CustomerBasicInfoDTO dto=service.saveCustomer(customer);
		return new ResponseEntity<CustomerBasicInfoDTO>(dto,HttpStatus.OK);
		/*}
		return null;*/
	}
	@GetMapping("/fbook")
	public  List<FlightBooking> getAllFBookings(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		return bookservice.getAllFlightBooking();
		}
		return null;
	}
	@PostMapping("/fbook")
	public ResponseEntity<FlightBookingInfoDTO> saveFBooking(@RequestBody FlightBookingSavePostDTO fbook,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null) {
		
		FlightBookingInfoDTO dto=bookservice.saveFlightBooking(fbook);
		return new ResponseEntity<FlightBookingInfoDTO>(dto,HttpStatus.OK);
		}
		return null;
	}
	@PostMapping("/hbook")
	public ResponseEntity<HotelBookingInfoDTO> saveHBooking(@RequestBody HotelBookingSavePostDTO hbook,HttpServletRequest req){
	
		HttpSession session=req.getSession(false);
		if(session!=null) {
		HotelBookingInfoDTO dto=bookservice.saveHotelBooking(hbook);
		return new ResponseEntity<HotelBookingInfoDTO>(dto,HttpStatus.OK);
		}
		return null;
	}
		
	
}
