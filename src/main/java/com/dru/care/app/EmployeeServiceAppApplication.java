package com.dru.care.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceAppApplication.class, args);
	}


	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
