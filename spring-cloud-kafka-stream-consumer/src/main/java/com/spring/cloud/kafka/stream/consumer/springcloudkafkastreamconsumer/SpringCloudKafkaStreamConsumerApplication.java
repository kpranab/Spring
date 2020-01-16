package com.spring.cloud.kafka.stream.consumer.springcloudkafkastreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages= {"com.spring.cloud.kafka.stream.consumer"})
@EnableCassandraRepositories(basePackages= {"com.spring.cloud.kafka.stream.consumer"})
public class SpringCloudKafkaStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKafkaStreamConsumerApplication.class, args);
	}

}
