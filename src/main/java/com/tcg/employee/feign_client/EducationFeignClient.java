package com.tcg.employee.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcg.employee.response_entity.ResponseQualification;

@FeignClient(name = "education-service", path = "/education-app/api")
public interface EducationFeignClient {
	
	@GetMapping(path = "/qualification/{id}")
	public ResponseEntity<ResponseQualification> getQualicationInfoById(@PathVariable(name = "id") long id);

}
