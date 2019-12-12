package com.spring.cloud.kafka.stream.consumer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface ConsumerTopics {
	

	String ACCOUNT = "ACCOUNT";
	String CREDIT_HISTORY = "CREDIT_HISTORY";

	@Input(ACCOUNT)
	MessageChannel account();

	@Input(CREDIT_HISTORY)
	MessageChannel credit_history();

}
