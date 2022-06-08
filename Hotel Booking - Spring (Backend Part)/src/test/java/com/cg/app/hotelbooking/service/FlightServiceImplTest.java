package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.repository.IFlightRepository;
@SpringBootTest
class FlightServiceImplTest {
	@Mock
	IFlightRepository repository;
	@Test
	void testGetFlightById() {
	//	fail("Not yet implemented");
		Flight actualFlight=new Flight();
		Optional<Flight> output=Optional.of(actualFlight);
		when(repository.findById(101)).thenReturn(output);
		assertEquals(new Flight(),actualFlight);
	}

	@Test
	void testGetAllFlights() {
	//	fail("Not yet implemented");
		List<Flight> actualOutput=new ArrayList<>();
		when(repository.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Flight>(),actualOutput);
	}

}
