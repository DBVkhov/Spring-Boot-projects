package com.lm2a.auth.service;

import com.lm2a.auth.dto.TokenDto;
import com.lm2a.auth.dto.UserDto;

public interface IAuthUserService {

	public UserDto save(UserDto userDto);
	
	public TokenDto login(UserDto userDto);
	
	public TokenDto validate(String token);
}
