package com.hotalService.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotalService.entity.Hotel;
import com.hotalService.exception.HotelException;
import com.hotalService.repo.HotelRepo;
import com.hotalService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel saveHotal(Hotel hotel) {
//		String hotelId = UUID.randomUUID().toString();
//		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public Optional<Hotel> getHotelById(String hotelId) {
		return Optional
				.of(hotelRepo.findById(hotelId).orElseThrow(() -> new HotelException("Resource Not found exception")));
	}

	@Override
	public List<Hotel> getHotel() {
		return hotelRepo.findAll();
	}

}
