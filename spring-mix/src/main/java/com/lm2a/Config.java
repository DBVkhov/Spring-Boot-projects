package com.lm2a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
public class Config {

	@Autowired
	private Parrot parrot;
	
	@Bean
	public Person person() {
		Person p = new Person();
		p.setName("Joaquin");
		p.setParrot(parrot);
		return p;
	}
}
