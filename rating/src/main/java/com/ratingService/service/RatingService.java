package com.ratingService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ratingService.entity.Rating;

@Service
public interface RatingService {
	Rating saveRating(Rating rating);


	List<Rating> getRating();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);

}
