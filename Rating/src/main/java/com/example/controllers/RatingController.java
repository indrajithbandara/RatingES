package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.beans.RatingBean;
import com.example.models.Rating;
import com.example.services.RatingService;
import com.example.services.RatingServiceImpl;

@Controller
@RequestMapping("/rating")
public class RatingController {
	
	private RatingService ratingService;
	
	@RequestMapping(value = "/getrating/{starsNumber}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> getRating(@PathVariable int starsNumber) {
		
		Rating rating = ratingService.findByStarsNumber(starsNumber);
		
		if(rating == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(rating, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saverating", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> saveRating(@RequestBody RatingBean requestBody){
		System.out.println(requestBody.getStarsNumber() + requestBody.getComment());
		try{
			
			Rating rating = new Rating (requestBody.getStarsNumber(), requestBody.getComment());
			ratingService.save(rating);
			return new ResponseEntity<>(rating, HttpStatus.CREATED);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Autowired
	public void setRatingService(RatingServiceImpl ratingServiceImpl) {
		this.ratingService = ratingServiceImpl;
	}
	
}

