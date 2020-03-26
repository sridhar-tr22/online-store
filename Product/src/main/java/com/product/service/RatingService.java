package com.product.service;

import com.product.dto.RatingDto;
import com.product.entity.Rating;
import com.product.exception.ProductNotFoundException;
import com.product.exception.UserNotFoundException;

public interface RatingService {
	
	public Rating giveRatingFeedback(RatingDto ratingDto)throws ProductNotFoundException,UserNotFoundException;

	

	

	

}
