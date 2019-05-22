package com.sapient.spring.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author prakumar56
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryMicroserviceServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(DiscoveryMicroserviceServerApplication.class, args);
	}

}
