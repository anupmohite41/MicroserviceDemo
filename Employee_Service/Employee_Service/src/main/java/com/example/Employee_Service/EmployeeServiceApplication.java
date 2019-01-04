package com.example.Employee_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.Employee_Service")
@EnableJpaRepositories("com.example.Employee_Service.configDaoRepository")
@EntityScan("com.example.Employee_Service.configDAO")
@EnableDiscoveryClient
public class EmployeeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
}