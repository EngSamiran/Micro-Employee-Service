package com.tcg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEmployeeServiceApplication.class, args);
	}

}
