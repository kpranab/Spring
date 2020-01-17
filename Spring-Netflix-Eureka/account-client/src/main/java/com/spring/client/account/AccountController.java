package com.spring.client.account;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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