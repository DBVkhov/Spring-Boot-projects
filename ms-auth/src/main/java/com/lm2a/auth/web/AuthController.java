package com.lm2a.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lm2a.auth.dto.TokenDto;
import com.lm2a.auth.dto.UserDto;
import com.lm2a.auth.service.IAuthUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	IAuthUserService service;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody UserDto dto){
		TokenDto tokenDto = service.login(dto);
		return ResponseEntity.ok(tokenDto);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<TokenDto> validate(@RequestParam String token){
		TokenDto tokenDto = service.validate(token);
		return ResponseEntity.ok(tokenDto);
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> create(@RequestBody UserDto dto){
		UserDto userDto = service.save(dto);
		return ResponseEntity.ok(userDto);
	}
	
	

}
