package com.tcg.employee.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcg.employee.custome_exception.ResourceNotFoundException;
import com.tcg.employee.response_entity.ResEmployee;
import com.tcg.employee.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "employee/{id}")
	//@CircuitBreaker(name = "AddressEducationBreaker", fallbackMethod = "addressEducationFallBack")
	//@Retry(name = "AddressEducationRetry", fallbackMethod = "addressEducationFallBack")
	@RateLimiter(name = "employeeRateLimiter", fallbackMethod = "addressEducationFallBack")
	public ResponseEntity<ResEmployee> getEmployeeById(@PathVariable(name = "id") long id) {
		ResEmployee employeeById = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeById);
	}
	
	public ResponseEntity<ResEmployee> addressEducationFallBack(long id, Exception exception){
		System.out.println(exception.getMessage());
		System.out.println(exception.getCause());
		ResEmployee resEmployee = new ResEmployee(00000l, "demo name"+exception.getMessage(), null, null);
		return ResponseEntity.ok(resEmployee);
	}

}
