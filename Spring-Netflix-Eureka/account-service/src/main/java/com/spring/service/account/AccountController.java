package com.spring.service.account;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prakumar56
 *
 */
@RestController
public class AccountController {

	protected Logger logger = Logger
			.getLogger(AccountController.class.getName());
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/accounts")
	public List<Account> all() {
		logger.info("accounts-microservice all() invoked");
		List<Account> accounts = accountRepository.findAll();
		logger.info("accounts-microservice all() found: " + accounts.size());
		return accounts;
	}
	
	@RequestMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") Long id) {
		logger.info("accounts-microservice byId() invoked: " + id);
		Optional<Account> account = accountRepository.findById(id);
		logger.info("accounts-microservice byId() found: " + account);
		return account.get();
	}
	
	@RequestMapping("/createAccounts")
	public String createAccount() {
		
		accountRepository.save(new Account( "Pranab", 35412L));
		accountRepository.save(new Account("Vishnu", 5412L));
		
		return "Account Crerated Successfully";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}
}