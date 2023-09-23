package com.lm2a.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/db-failover/dragonball")
public class CharacterController {

	private Faker faker = new Faker();
	private List<String> characters = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		for(int i=0; i<10; ++i) {
			characters.add(String.format("Failover - %s", faker.dragonBall().character()));
		}
	}
		
	@GetMapping("/characters")
	public List<String> getAllCharacters(){
			return characters;
	}

	@GetMapping("/{name}")
	public String getCharacter(@PathVariable String name) {
		return characters.stream().filter(x -> x.contains(name)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s no existe!", name)));
	}
	
	@GetMapping("/prefix/{prefix}")
	public List<String> getCharacterWithPrefix(@PathVariable String prefix){
	    return characters.stream().filter(s -> s.startsWith(prefix)).collect(Collectors.toList());
	}
}

