package com.tcg.employee.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcg.employee.response_entity.ResponseAddress;


@FeignClient(name = "address-service" , path = "/address-app/api/")
public interface AddressFeignClient {
	
	@GetMapping(path = "address/{id}")
	public ResponseEntity<ResponseAddress> getAddressById(@PathVariable(name = "id") long id);

}
