package com.example.services;

import com.example.models.Rating;

public interface RatingService {
	public Rating findByStarsNumber(int starsNumber);
	public Rating save(Rating rating);

}
