package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.RatingBean;
import com.example.models.Rating;
import com.example.services.RatingService;
import com.example.services.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	private RatingService ratingService;
	
	@RequestMapping(value = "/getrating/{stars_number}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> getRating(@PathVariable int stars_number) {
		
		Rating rating = ratingService.findByStarsNumber(stars_number);
		
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
		System.out.println(requestBody.getStars_number() + requestBody.getComment());
		try{
			
			Rating rating = new Rating (requestBody.getStars_number(), requestBody.getComment());
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

