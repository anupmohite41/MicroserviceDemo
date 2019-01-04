package com.example.CallingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CallingService.DemoObject;

@RestController
@RequestMapping("/test")
public class serviceController {

	@Autowired
	DiscoveryClient dc;

	@GetMapping("/")
	public String test() {
		return "Welcome";
	}

	@GetMapping("/instances")
	public String getInstances() {
		List<ServiceInstance> instances = dc.getInstances("Employee_login");
		System.out.println("Instances :: " + instances.size());
		ServiceInstance serviceInstance = instances.get(0);
		String url = serviceInstance.getUri().toString();
		System.out.println("url 1 :: " + url);
		RestTemplate restTemplate = new RestTemplate();
		url = "http://localhost:8080/demo";
		System.out.println("url 2 :: " + url);
		DemoObject helloObject = restTemplate.getForObject(url, DemoObject.class);
		System.out.println("helloObject :: " + helloObject);
		System.out.println("Message :: "+helloObject.getMessage());
		return helloObject.getMessage();
	}
}
