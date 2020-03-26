package com.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.training.dto.RatingDto;
import com.training.dto.Response;
import com.training.entities.Rating;
import com.training.exceptions.ProductNotFoundException;
import com.training.exceptions.UserNotFoundException;
import com.training.services.RatingServiceImpl;


@WebMvcTest
public class RatingControllerTest {

	Rating rate = null;
	RatingDto ratingDto = null;
	Response response = new Response();

	@Autowired
	RatingController ratingController;

	@MockBean
	RatingServiceImpl ratingService;

	@Test
	public void testRating() throws ProductNotFoundException, UserNotFoundException {

		rate = new Rating();
		rate.setProductId(100L);
		rate.setSellerFeedback("Good");
		rate.setSellerRating(4);
		rate.setUserFeedback("Good");
		rate.setUserId(1L);
		rate.setUserRating("Good");

		ratingDto = new RatingDto();
		ratingDto.setProductId(100L);
		ratingDto.setSellerFeedback("Good");
		ratingDto.setSellerRating(4);
		ratingDto.setUserFeedback("Good");
		ratingDto.setUserId(1L);
		ratingDto.setUserRating("Good");

		RatingDto any = Mockito.any(RatingDto.class);
		
	 Mockito.when(ratingService.giveRatingFeedback(any)).thenReturn(rate);
		ResponseEntity<Response> res = ratingController.giverating(ratingDto);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());

	}

}
