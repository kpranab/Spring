package com.spring.client.account;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author prakumar56
 *
 */
@RestController
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@HystrixCommand(fallbackMethod = "fallbackAccountList")
	@RequestMapping("/accountList")
	public List<Account> accountList() {
		return accountRepository.getAllAccounts();
	}

	@RequestMapping("/accountDetails")
	public Account accountDetails(@RequestParam("number") Long id) {
		return accountRepository.getAccount(id);
	}

	public List<Account> fallbackAccountList() {
		Account[] account = { new Account(100L, "Muna", "12819") };
		return Arrays.asList(account);
	}

	@RequestMapping("/employee")
	public Employee getEmployee() {
		return accountRepository.getEmployee();
	}

}