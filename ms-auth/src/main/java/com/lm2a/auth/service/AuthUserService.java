package com.lm2a.auth.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lm2a.auth.config.JwtProvider;
import com.lm2a.auth.dto.TokenDto;
import com.lm2a.auth.dto.UserDto;
import com.lm2a.auth.entity.UserEntity;
import com.lm2a.auth.repository.UserRepository;

@Service
public class AuthUserService implements IAuthUserService {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JwtProvider provider;

	@Override
	public UserDto save(UserDto userDto) {
		Optional<UserEntity> entity = repository.findUserByUsername(userDto.getUsername());
		if(entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s already exist", userDto.getUsername()));
		}
		
		UserEntity userEntity = repository.save(new UserEntity(userDto.getUsername(), encoder.encode(userDto.getPassword())));
		return mapper.map(userEntity, UserDto.class);
	}
	

	@Override
	public TokenDto login(UserDto userDto) {
		Optional<UserEntity> entity = repository.findUserByUsername(userDto.getUsername());
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		if(encoder.matches(userDto.getPassword(), entity.get().getPassword())) {
			return new TokenDto(provider.createToken(entity.get()));
		}
		
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
	}

	@Override
	public TokenDto validate(String token) {
		if(!provider.validate(token)){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		String username = provider.getUsernameFromToken(token);
		Optional<UserEntity> entity = repository.findUserByUsername(username);
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		return new TokenDto(token);
	}

}
