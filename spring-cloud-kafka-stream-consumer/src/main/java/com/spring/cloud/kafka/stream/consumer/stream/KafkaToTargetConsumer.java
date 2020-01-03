package com.spring.cloud.kafka.stream.consumer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.spring.cloud.kafka.stream.consumer.model.Account;
import com.spring.cloud.kafka.stream.consumer.model.BillingAccount;
import com.spring.cloud.kafka.stream.consumer.model.CreditHistory;
import com.spring.cloud.kafka.stream.consumer.repository.BillingAccountRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaToTargetConsumer {

	@Autowired
	BillingAccountRepository billingAccountRepository;
	
	@StreamListener(ConsumerTopics.ACCOUNT)
	public void handleAccount(@Payload Account account) {
		log.info("Received handleAccount : {}",account);
		billingAccountRepository.insert(BillingAccount.builder()
				.account_number(account.getAccount_number())
				.account_status(account.getAccount_status())
				.account_type(account.getAccount_type())
				.account_subtype(account.getAccount_subtype())
				.line_of_business(account.getLine_of_business())
				.timestamp(account.getTimestamp()).build());
		
	}

	@StreamListener(ConsumerTopics.CREDIT_HISTORY)
	public void handleCreditHistory(@Payload CreditHistory creditHistory) {
		log.info("Received handleCreditHistory : {}",creditHistory);
		billingAccountRepository.insert(BillingAccount.builder()
				.account_number(creditHistory.getAccount_number())
				.credit_class(creditHistory.getCredit_class()).build());
	}
}
