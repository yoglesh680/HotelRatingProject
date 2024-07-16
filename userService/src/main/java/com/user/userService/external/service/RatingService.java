package com.user.userService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.userService.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@PostMapping("/rating")
	Rating saveRating(@RequestBody Rating rating);

	@PutMapping("/rating/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingId, @RequestBody Rating rating);

	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}
