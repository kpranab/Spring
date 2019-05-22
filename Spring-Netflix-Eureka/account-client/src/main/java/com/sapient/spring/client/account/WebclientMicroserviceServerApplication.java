package com.sapient.spring.client.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author prakumar56
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
public class WebclientMicroserviceServerApplication {
	
	public static final String ACCOUNTS_SERVICE_URL = "https://ACCOUNTS-MICROSERVICE";
	
	public static void main(String[] args) {
		SpringApplication.run(WebclientMicroserviceServerApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public AccountRepository accountRepository(){
		return new RemoteAccountRepository(ACCOUNTS_SERVICE_URL);
	}
}