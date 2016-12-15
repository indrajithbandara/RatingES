package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Rating;
import com.example.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	private RatingRepository ratingRepository;
	
	@Autowired
	public void setRatingRepository(RatingRepository repository){
		this.ratingRepository = repository;
	}

	@Override
	public Rating findByStarsNumber(int starsNumber) {
		return ratingRepository.findByStarsNumber(starsNumber);
	}

	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

}
