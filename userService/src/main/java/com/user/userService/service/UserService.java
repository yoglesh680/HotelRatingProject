package com.user.userService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.userService.entity.User;

@Service
public interface UserService {
	User saveUser(User user);

	List<User> getUsers();

	User getUserById(String id);

}
