package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.RatingDto;
import com.training.dto.Response;
import com.training.entities.Rating;
import com.training.exceptions.ProductNotFoundException;
import com.training.exceptions.UserNotFoundException;
import com.training.services.RatingService;;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService rs;
	
	
	@PostMapping(value="/users/rating")
	public ResponseEntity<Response>giverating(@RequestBody RatingDto rating)throws ProductNotFoundException,UserNotFoundException{
		Rating rate=rs.giveRatingFeedback(rating);
		Response res=new Response();
		res.setMessage("rating added successfully");
		res.setStatusCode("200");
		res.setRating(rate);
	return new ResponseEntity<Response>(res,HttpStatus.CREATED);
		
	}

}
