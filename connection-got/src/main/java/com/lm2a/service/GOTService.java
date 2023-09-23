package com.lm2a.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name="got")
public class GOTService {
	
	@GetMapping("/characters")
	public List<String> getAllCharacters();
	
	@GetMapping("/{name}")
	public String GetOneCharGot();
}