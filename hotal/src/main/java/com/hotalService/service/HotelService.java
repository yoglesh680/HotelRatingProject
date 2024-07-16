package com.hotalService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotalService.entity.Hotel;

@Service
public interface HotelService {
	Hotel saveHotal(Hotel hotel);

	Optional<Hotel> getHotelById(String hotelId);

	List<Hotel> getHotel();

}
