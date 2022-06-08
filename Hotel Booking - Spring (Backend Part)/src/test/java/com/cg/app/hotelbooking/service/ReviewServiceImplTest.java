package com.cg.app.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.app.hotelbooking.entities.Hotel;
import com.cg.app.hotelbooking.entities.Review;
import com.cg.app.hotelbooking.repository.IReviewRepository;
@SpringBootTest
class ReviewServiceImplTest {
	@Mock
	IReviewRepository repository;
	@Test
	void testGetallreviews() {
		List<Review> actualOutput=new ArrayList<>();
		when(repository.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Review>(), actualOutput);
	}

	@Test
	void testGetreviewbyhotelname() {
		List<Review> actualOutput=new ArrayList<>();
		when(repository.getreviewbyhotelname("sitara")).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Review>(),actualOutput);
	}

	@Test
	void testGetreviewbyflightname() {
		List<Review> actualOutput=new ArrayList<>();
		when(repository.getreviewbyflightname("air asia")).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Review>(),actualOutput);
		
	}
}
	