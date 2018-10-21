/**
 * 
 */
package com.rnd.springboot.jpa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@EntityScan(basePackages = "com.rnd.springboot.jpa.entity")
@EnableJpaRepositories("com.rnd.springboot.jpa.repo")
@SpringBootApplication(scanBasePackages={"com.rnd.springboot.jpa"})
public class SpringBootRestServiceJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceJPAApplication.class, args);
	}
}
//http://localhost:8080/h2-console/