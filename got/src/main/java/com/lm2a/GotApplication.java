package com.lm2a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GotApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotApplication.class, args);
	}

}
