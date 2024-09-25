package com.tcg.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tcg.employee.custome_exception.ResourceNotFoundException;
import com.tcg.employee.entity.Employee;
import com.tcg.employee.feign_client.AddressFeignClient;
import com.tcg.employee.feign_client.EducationFeignClient;
import com.tcg.employee.repo.EmployeeRepo;
import com.tcg.employee.response_entity.ResEmployee;
import com.tcg.employee.response_entity.ResponseAddress;
import com.tcg.employee.response_entity.ResponseQualification;
import com.tcg.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private WebClient webClient;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
//	@Autowired
//	private  LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private AddressFeignClient addressFeignClient;
	
	@Autowired
	private EducationFeignClient educationFeignClient;

	@Override
	public ResEmployee getEmployeeById(long id) {
		Optional<Employee> empOptional = employeeRepo.findById(id);
		if (empOptional.isPresent()) {
			Employee employee = empOptional.get();
			ResEmployee resEmployee = modelMapper.map(employee, ResEmployee.class);
			
			/****Get instant from discovery client without load balancing****/
//			List<ServiceInstance> addressInstances = discoveryClient.getInstances("address-service");
//			ServiceInstance addressServiceInstance = addressInstances.get(0);
//			String baseUrl = addressServiceInstance.getUri().toString();
			
			/****Get instant from LoadBalancerClient client with load balancing****/
//			ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//			String baseUrl = serviceInstance.getUri().toString();
//			String contextRoot = serviceInstance.getMetadata().get("contextRoot");			
//			System.out.println("baseUrl+contextRoot====> "+baseUrl+contextRoot);
			
			
//			ResponseAddress responseAddressUsingWebClient = callingAddressServiceUsingWebClient(id);
//			resEmployee.setAddress(responseAddressUsingWebClient);
//			System.out.println("Address service URL = "+baseUrl);
			
//			ResponseAddress addressServiceUsingRestTemplate = callingAddressServiceUsingRestTemplate(baseUrl+contextRoot, id);
//			resEmployee.setAddress(addressServiceUsingRestTemplate);
			
			
//			ResponseAddress responseAddress = restTemplate.getForObject("http://address-service/address-app/api/address/{addressId}", ResponseAddress.class, id);
//			resEmployee.setAddress(responseAddress);
			
			ResponseEntity<ResponseAddress> addressResponseEntity = addressFeignClient.getAddressById(id);
			ResponseAddress responseAddress = addressResponseEntity.getBody();
			resEmployee.setAddress(responseAddress);
			
			ResponseEntity<ResponseQualification> qualicationInfoById = educationFeignClient.getQualicationInfoById(id);
			ResponseQualification responseQualification = qualicationInfoById.getBody();
			resEmployee.setQualification(responseQualification);
			
			
			return resEmployee;
		}
		throw new ResourceNotFoundException("ID : "+ id + " not found our end, verify id and try again.");
	}
	
//	private ResponseAddress callingAddressServiceUsingWebClient(String baseUrl, long addressId) {
//		return webClient.
//				get()
//				.uri("/address/"+addressId)
//				.retrieve()
//				.bodyToMono(ResponseAddress.class)
//				.block();
//	}
	
//	private ResponseAddress callingAddressServiceUsingRestTemplate(String baseUrlWithContextPath, long addressId) {
////		return restTemplate.getForObject("http://localhost:8081/address-service/api/address/{addressId}", ResponseAddress.class, addressId);
//		return restTemplate.getForObject(baseUrlWithContextPath+"/address/{addressId}", ResponseAddress.class, addressId);
//	}

}
