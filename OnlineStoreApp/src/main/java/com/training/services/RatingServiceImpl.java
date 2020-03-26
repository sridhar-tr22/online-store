package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.RatingDto;
import com.training.entities.Rating;
import com.training.exceptions.ProductNotFoundException;
import com.training.exceptions.UserNotFoundException;
import com.training.repositories.RatingRepo;

import com.training.services.RatingService;


@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo rp;
	
	
	@Override
	public Rating giveRatingFeedback(RatingDto ratingDto)throws ProductNotFoundException,UserNotFoundException{
		Rating rate=new Rating(ratingDto.getProductId(),ratingDto.getUserId(),ratingDto.getSellerFeedback(),ratingDto.getUserFeedback(),
				ratingDto.getSellerRating(),ratingDto.getUserRating());
		return rp.save(rate);			
		
	}

}
