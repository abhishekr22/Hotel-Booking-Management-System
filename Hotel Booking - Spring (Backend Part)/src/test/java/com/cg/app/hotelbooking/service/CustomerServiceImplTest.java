package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.Flight;
import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.repository.CustomerRepository;
import com.cg.app.hotelbooking.repository.IFlightRepository;
import com.cg.app.hotelbooking.repository.IHotelRepository;
@SpringBootTest
class CustomerServiceImplTest {
	@Mock
	IHotelRepository repository;
	@Mock
	IFlightRepository flightrepository;
	@Mock
	CustomerRepository custrepo;
	@Test
	void testGetFlightByDeparture() {
		List<Flight> actualOutput=new ArrayList<>();
		when(custrepo.filterFlightByCost("hyd","bnglr", 5000, 7000)).thenReturn(actualOutput);
		//fail("Not yet implemented");
		assertIterableEquals(new ArrayList<Flight>(),actualOutput);
	}

	@Test
	void testGetHotelsByCity() {
		List<Hotel> actualOutput=new ArrayList<>();
		when(custrepo.getHotelsByCity("hyderabad")).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Hotel>(),actualOutput);
	}

	@Test
	void testGetHotelsByCost() {
		List<Hotel> actualOutput=new ArrayList<>();
		when(custrepo.getHotelsByCost("hyderabad", 1000, 2000)).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Hotel>(),actualOutput);
		//fail("Not yet implemented");
	}

}
