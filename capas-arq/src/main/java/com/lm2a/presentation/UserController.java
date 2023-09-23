package com.lm2a.presentation;

import com.lm2a.model.User;
import com.lm2a.service.UserService;

public class UserController {
	
	UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}


	public void showUser(String dni) {
		User userByDNI = userService.getUserByDNI(dni);
		if(userByDNI != null) {
			p(userByDNI.toString());
		}
	}
	
	public void p(String txt) {
		System.out.println(txt);
	}

}
