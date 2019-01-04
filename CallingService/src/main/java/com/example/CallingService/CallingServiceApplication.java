package com.example.CallingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CallingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallingServiceApplication.class, args);
	}

}

