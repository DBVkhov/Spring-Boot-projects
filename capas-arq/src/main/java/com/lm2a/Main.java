package com.lm2a;

import com.lm2a.data.UserRepository;
import com.lm2a.data.UserRepositoryImpl;
import com.lm2a.presentation.UserController;
import com.lm2a.service.UserService;
import com.lm2a.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		UserRepository repo = new UserRepositoryImpl();
		UserService service = new UserServiceImpl(repo);
		UserController controller = new UserController(service);
		controller.showUser("123456T");

	}

}
