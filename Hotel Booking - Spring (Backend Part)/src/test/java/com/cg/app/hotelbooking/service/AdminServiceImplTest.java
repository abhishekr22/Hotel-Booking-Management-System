 package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.Passengers;
import com.cg.app.hotelbooking.repository.CustomerRepository;
@SpringBootTest
class AdminServiceImplTest {
	@Mock
	CustomerRepository repository;
	@Test
	void testGetCustomerInfo() {
		Passengers actualPassenger=new Passengers();
		Optional<Passengers> output=Optional.of(actualPassenger);
		when((repository.findById(1))).thenReturn(output);
		assertEquals(new Passengers(),actualPassenger);
	}

	@Test
	void testGetCustomerList() {
		List<Passengers> actualOutput=new ArrayList<>();
		when(repository.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Passengers>(),actualOutput);
		
	}

}
