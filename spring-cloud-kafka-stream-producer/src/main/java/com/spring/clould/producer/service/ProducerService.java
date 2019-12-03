package com.spring.clould.producer.service;

import com.spring.clould.producer.model.Account;
import com.spring.clould.producer.model.CreditHistory;

public interface ProducerService {
	
	public void publishAccountInfo(Account account);
	public void publishCreditHistory(CreditHistory creditHistory);

}
