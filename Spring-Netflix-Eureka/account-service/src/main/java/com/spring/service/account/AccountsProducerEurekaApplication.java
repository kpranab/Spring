package com.spring.service.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author prakumar56
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountsProducerEurekaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(AccountsProducerEurekaApplication.class, args);

	}

}
