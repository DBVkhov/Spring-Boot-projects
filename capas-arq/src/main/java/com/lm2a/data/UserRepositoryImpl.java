package com.lm2a.data;

import java.util.ArrayList;
import java.util.List;

import com.lm2a.model.User;

public class UserRepositoryImpl implements UserRepository {
	
	ArrayList<User> users;

	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		User u1 = new User("Juan1", "Valdez1", "123456Q", 1940);
		User u2 = new User("Juan2", "Valdez2", "123456W", 1962);
		User u3 = new User("Juan3", "Valdez3", "123456E", 1973);
		User u4 = new User("Juan4", "Valdez4", "123456R", 1990);
		User u5 = new User("Juan5", "Valdez5", "123456T", 1999);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
	}

	public void saveUser(User user) {
		users.add(user);
	}

	public User getUserByDNI(String dni) {
		for(User u: users) {
			if(u.getDni().equals(dni)) {
				return u;
			}
		}
		return null;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public void deleteUser(String dni) {
		User u = getUserByDNI(dni);
		if(u != null) {
			users.remove(u);
		}
	}

	public User modifyUser(User user) {
		User u = getUserByDNI(user.getDni());
		u.setBirthYear(user.getBirthYear());
		u.setLastName(user.getLastName());
		u.setName(user.getName());
		return u;
	}

}
