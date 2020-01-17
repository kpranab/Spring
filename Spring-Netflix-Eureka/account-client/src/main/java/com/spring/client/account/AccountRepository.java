package com.spring.client.account;

import java.util.List;

/**
 * @author prakumar56
 *
 */
public interface AccountRepository {
	List<Account> getAllAccounts();

	Account getAccount(Long number);
	
	Employee getEmployee();

}
