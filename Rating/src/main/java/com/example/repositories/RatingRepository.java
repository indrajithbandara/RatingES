package com.example.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Rating;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	@Query(value = "Select rating from Rating rating where rating.starsNumber=:starsNumber")
	public Rating findByStarsNumber(@Param("starsNumber") int starsNumber);

}
