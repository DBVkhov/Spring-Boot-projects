package com.lm2a.auth.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MappingConfig {

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
