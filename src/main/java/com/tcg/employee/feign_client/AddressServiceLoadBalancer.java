package com.tcg.employee.feign_client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;
//this class is used for customize load balancer. Spring cloud and feign client default load balancer set Round Robin fashion
// In MyCustomeLoadBalancerConfiguration class i have set (get address service instant random fashion)
//If you want to used default load balancer then the AddressServiceLoadBalancer class and MyCustomeLoadBalancerConfiguration class not required
//@LoadBalancerClient(value = "address-service", configuration = MyCustomeLoadBalancerConfiguration.class)
@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancer {
	
	@Bean
	@LoadBalanced
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}

}
