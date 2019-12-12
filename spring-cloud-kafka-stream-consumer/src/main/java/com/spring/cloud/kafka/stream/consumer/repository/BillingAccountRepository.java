package com.spring.cloud.kafka.stream.consumer.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.spring.cloud.kafka.stream.consumer.model.BillingAccount;

public interface BillingAccountRepository extends CassandraRepository<BillingAccount, String>{

}
