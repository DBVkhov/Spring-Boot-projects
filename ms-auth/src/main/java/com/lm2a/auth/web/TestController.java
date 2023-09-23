package com.lm2a.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lm2a.auth.config.JwtProvider;
import com.lm2a.auth.entity.UserEntity;

@RestController
public class TestController {

	@Autowired
	JwtProvider jwtProvider;
	
	
	@GetMapping("/test")
	public String test() {
		UserEntity u = new UserEntity("lm2a","secreto");
		String token = jwtProvider.createToken(u);
		return token;
	}
}
