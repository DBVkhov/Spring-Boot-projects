package com.lm2a.service;

import java.util.List;

import com.lm2a.data.UserRepository;
import com.lm2a.model.User;

public class UserServiceImpl implements UserService {
	
	UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public void saveUser(User user) {
		userRepo.saveUser(user);
	}

	public User getUserByDNI(String dni) {
		return userRepo.getUserByDNI(dni);
	}

	public List<User> getAllUsers() {
		return userRepo.getAllUsers();
	}

	public void deleteUser(String dni) {
		userRepo.deleteUser(dni);

	}

	public User modifyUser(User user) {
		return userRepo.modifyUser(user);
	}

	public int getAge(User u) {
		return 2023-u.getBirthYear();
	}

	public String getFullName(User u) {
		return u.getName()+" "+u.getLastName();
	}

}
