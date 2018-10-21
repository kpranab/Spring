package com.flight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Pranab Kumar Sahoo
 *
 */
@SpringBootApplication(scanBasePackages={"com.flight"})
public class SpringBootFlightSearchApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlightSearchApp.class, args);
	}

}
