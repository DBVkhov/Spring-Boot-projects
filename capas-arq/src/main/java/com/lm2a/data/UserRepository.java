package com.lm2a.data;

import java.util.List;

import com.lm2a.model.User;

public interface UserRepository {	
	void saveUser(User user);
	User getUserByDNI(String dni);
	List<User> getAllUsers();
	void deleteUser(String dni);
	User modifyUser(User user);
}
