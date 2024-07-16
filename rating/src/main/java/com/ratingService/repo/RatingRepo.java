package com.ratingService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingService.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {
	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String userId);
}
