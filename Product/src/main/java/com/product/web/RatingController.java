package com.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.RatingDto;
import com.product.dto.Response;
import com.product.entity.Rating;
import com.product.exception.ProductNotFoundException;
import com.product.exception.UserNotFoundException;
import com.product.service.RatingService;

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
