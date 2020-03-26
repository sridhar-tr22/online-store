package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.product.dto.RatingDto;
import com.product.entity.Rating;
import com.product.exception.ProductNotFoundException;
import com.product.exception.UserNotFoundException;
import com.product.repo.RatingRepo;
import com.product.service.Impl.RatingServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RatingService {
	
	Rating rate=null;
	RatingDto ratingDto=null;
	
	@Mock
	private RatingRepo repo;
	
	@InjectMocks
	private RatingServiceImpl rs;
	
	@Test
	public void testRating() throws ProductNotFoundException,UserNotFoundException{
		
		rate=new Rating();
		rate.setProductId(100L);
		rate.setSellerFeedback("Good");
		rate.setSellerRating(4);
		rate.setUserFeedback("Good");
		rate.setUserId(1L);
		rate.setUserRating("Good");
		
		ratingDto=new RatingDto();
		ratingDto.setProductId(100L);
		ratingDto.setSellerFeedback("Good");
		ratingDto.setSellerRating(4);
		ratingDto.setUserFeedback("Good");
		ratingDto.setUserId(1L);
		ratingDto.setUserRating("Good");
		
		Mockito.when(repo.save(rate)).thenReturn(rate);
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(rate));
		Rating rg=rs.giveRatingFeedback(ratingDto);
		assertEquals(rate.getProductId(),rg.getProductId() );
		
		
	}
	
	

}
