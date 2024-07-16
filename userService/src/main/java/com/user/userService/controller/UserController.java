package com.user.userService.controller;

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

import com.user.userService.entity.User;
import com.user.userService.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = service.getUsers();
		return ResponseEntity.ok(user);
	}

	int retryCount = 1;

	@GetMapping("/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotel", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		System.out.println("Retry Count" + retryCount);
		retryCount++;
		User user = service.getUserById(id);
		return ResponseEntity.ok(user);
	}

	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
		ex.printStackTrace();

		User user = new User();
		user.setMail("dummy@gmail.com");
		user.setName("Dummy");
		user.setAbout("This user is created dummy because some service is down");
		user.setId("141234");
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	}

}
