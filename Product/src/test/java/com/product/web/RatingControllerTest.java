package com.product.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.dto.RatingDto;
import com.product.dto.Response;
import com.product.entity.Rating;
import com.product.exception.ProductNotFoundException;
import com.product.exception.UserNotFoundException;
import com.product.service.RatingService;
import com.product.web.RatingController;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RatingControllerTest {

	Rating rate = null;
	RatingDto ratingDto = null;
	Response response = new Response();

	@InjectMocks
	RatingController ratingController;

	@Mock
	RatingService ratingService;

	@Before
	public void before() {

	}

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

	 Mockito.when(ratingService.giveRatingFeedback(ratingDto)).thenReturn(rate);
		ResponseEntity<Response> res = ratingController.giverating(ratingDto);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());

	}

}
