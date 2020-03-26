package com.training.services;

import com.training.dto.RatingDto;
import com.training.entities.Rating;
import com.training.exceptions.ProductNotFoundException;
import com.training.exceptions.UserNotFoundException;;

public interface RatingService {

	public Rating giveRatingFeedback(RatingDto ratingDto) throws ProductNotFoundException, UserNotFoundException;

}
