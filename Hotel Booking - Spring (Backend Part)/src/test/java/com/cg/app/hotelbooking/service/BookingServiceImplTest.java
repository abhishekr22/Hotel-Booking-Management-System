package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.FlightBooking;
import com.cg.app.hotelbooking.repository.IFlightBookingRepository;
@SpringBootTest
class BookingServiceImplTest {
	@Mock
	IFlightBookingRepository repository;
	
	@Test
	void testGetAllFlightBooking() {
		//FlightBooking actualFlightBooking=new FlightBooking();
		List<FlightBooking> actualOutput=new ArrayList<>();
		when(repository.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<FlightBooking>(),actualOutput);
		
	}

}
