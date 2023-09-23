package com.lm2a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lm2a.config.DBConfig;

@RestController
@RequestMapping("/application-name")
public class ApplicationNameController {

	private static final Logger log = LoggerFactory.getLogger(ApplicationNameController.class);

	@Autowired
	DBConfig config;
	
	@GetMapping
	public ResponseEntity<String> getAppName(){
//		if(config.isActivateFunctionality()) {
//			return ResponseEntity.ok("XXX-"+config.getApplicationName());
//		}
		log.info("Atendiendo peticion de nombre.");
		return ResponseEntity.ok(config.getApplicationName());
	}
}
