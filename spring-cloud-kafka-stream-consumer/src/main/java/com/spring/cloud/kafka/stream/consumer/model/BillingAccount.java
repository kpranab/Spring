package com.spring.cloud.kafka.stream.consumer.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table("billing_account")
public class BillingAccount {
	
	@PrimaryKey
	private String account_number;
	private String account_type;
	private String account_subtype;
	private String line_of_business;
	private String account_status;
	private String credit_class;
	private long timestamp;

}
