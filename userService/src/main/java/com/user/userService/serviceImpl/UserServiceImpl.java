package com.user.userService.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.userService.entity.Hotel;
import com.user.userService.entity.Rating;
import com.user.userService.entity.User;
import com.user.userService.exception.UserException;
import com.user.userService.external.service.HotelService;
import com.user.userService.repo.UserRepository;
import com.user.userService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
//		http://localhost:8082/api/rating/user/1
		User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not found "));
		@SuppressWarnings("unchecked")
		Rating[] responseEntity = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getId(),
				Rating[].class);
		List<Rating> list;
		 list = Arrays.stream(responseEntity).collect(Collectors.toList());
		List<Rating> ratingList = list.stream().map(rating -> {
//				ResponseEntity<Hotel> entity = restTemplate
//						.getForEntity("http://HOTEL-SERVICE/api/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatingList(ratingList);
		return user;

	}

}
