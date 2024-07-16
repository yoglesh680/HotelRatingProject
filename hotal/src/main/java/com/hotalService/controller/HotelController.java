package com.hotalService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotalService.entity.Hotel;
import com.hotalService.service.HotelService;

@RequestMapping("/hotels")
@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel hotel1 = hotelService.saveHotal(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> hotel = hotelService.getHotel();
		return ResponseEntity.ok(hotel);

	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Optional<Hotel>> getHotelByID(@PathVariable String hotelId) {
		Optional<Hotel> hotel = hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotel);

	}

}
