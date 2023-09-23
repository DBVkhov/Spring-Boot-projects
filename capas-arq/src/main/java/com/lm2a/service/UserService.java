package com.lm2a.service;

import java.util.List;

import com.lm2a.model.User;

public interface UserService {

	void saveUser(User user);
	User getUserByDNI(String dni);
	List<User> getAllUsers();
	void deleteUser(String dni);
	User modifyUser(User user);
	
	int getAge(User u);
	String getFullName(User u);
}
