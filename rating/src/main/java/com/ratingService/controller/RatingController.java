package com.ratingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingService.entity.Rating;
import com.ratingService.service.RatingService;

@RequestMapping("/rating")
@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating rating1 = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);

	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> listRating = ratingService.getRating();
		return ResponseEntity.ok(listRating);

	}

	@GetMapping("user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId) {
		List<Rating> rating = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(rating);

	}

	@GetMapping("hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
		List<Rating> rating = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rating);

	}
}
