package com.spring.cloud.kafka.stream.consumer.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.kafka.stream.consumer.model.BillingAccount;

@Repository
public interface BillingAccountRepository extends CassandraRepository<BillingAccount, String>{

}
