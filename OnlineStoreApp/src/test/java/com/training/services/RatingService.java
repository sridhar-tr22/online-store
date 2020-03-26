package com.training.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.training.dto.RatingDto;
import com.training.entities.Rating;
import com.training.exceptions.ProductNotFoundException;
import com.training.exceptions.UserNotFoundException;
import com.training.repositories.RatingRepo;


//@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class RatingService {
	
	Rating rate=null;
	RatingDto ratingDto=null;
	
	@MockBean
	private RatingRepo repo;
	
	@Autowired
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
