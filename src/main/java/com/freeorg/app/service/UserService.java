package com.freeorg.app.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.freeorg.app.domain.User;

public class UserService {

	private static UserService userService = new UserService();
	private Set<User> usersSet = new HashSet<User>();
	private UserService() {
	}

	public static UserService getInstance() {
		return userService;
	}

	public void add(String id, String mobileNumber) {
		usersSet.add(new User(id, mobileNumber));

	}

	public User get(String userId) {
		return usersSet.stream()
				.filter(u -> u.getId().equals(userId))
				.findFirst().get();
	}
}
