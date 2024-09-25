package com.tcg.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableDiscoveryClient  //this not mandatory
public class EmployeeServiceConfiguration {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	WebClient webClient() {
		return WebClient
				.builder()
				.baseUrl("http://localhost:8081/address-service/api")
				.build();
	}
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
