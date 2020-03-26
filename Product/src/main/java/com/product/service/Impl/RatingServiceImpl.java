package com.product.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.RatingDto;
import com.product.entity.Rating;
import com.product.exception.ProductNotFoundException;
import com.product.exception.UserNotFoundException;
import com.product.repo.RatingRepo;

import com.product.service.RatingService;


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
