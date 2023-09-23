package com.lm2a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class gotApplication {

	public static void main(String[] args) {
		SpringApplication.run(gotApplication.class, args);
	}

}
