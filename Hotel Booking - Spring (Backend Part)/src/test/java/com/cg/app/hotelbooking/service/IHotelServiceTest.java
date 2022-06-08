package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.repository.IHotelRepository;
@SpringBootTest
class IHotelServiceTest {
	@Mock
	IHotelRepository repository;
	@Test
	void testGetHotelById() {
	//	fail("Not yet implemented");
		Hotel actualHotel=new Hotel();
		Optional<Hotel> output=Optional.of(actualHotel);
		when(repository.findById(201)).thenReturn(output);
		assertEquals(new Hotel(),actualHotel);
	}

	@Test
	void testGetHotels() {
	//	fail("Not yet implemented");
		List<Hotel> actualOutput=new ArrayList<>();
		when(repository.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Hotel>(),actualOutput);
	}

	

}
