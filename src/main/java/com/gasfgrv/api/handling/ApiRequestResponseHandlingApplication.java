package com.gasfgrv.api.handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiRequestResponseHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRequestResponseHandlingApplication.class, args);
	}

}
