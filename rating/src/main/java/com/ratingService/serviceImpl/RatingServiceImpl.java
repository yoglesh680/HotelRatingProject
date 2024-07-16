package com.ratingService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingService.entity.Rating;
import com.ratingService.repo.RatingRepo;
import com.ratingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating saveRating(Rating rating) {
		String id=UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRating() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
