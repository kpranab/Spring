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
import org.springframework.web.client.RestTemplate;

/**
 * @author prakumar56
 *
 */
public class RemoteAccountRepository implements AccountRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteAccountRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Account> getAllAccounts() {
		Account[] accounts = restTemplate.getForObject(serviceUrl+"/accounts", Account[].class);
		return Arrays.asList(accounts);
	}

	@Override
	public Account getAccount(Long number) {
		return restTemplate.getForObject(serviceUrl + "/accounts/{id}",
				Account.class, number);
	}

	@Override
	public Employee getEmployee() {
		String baseUrl = serviceUrl+"/employee";
		ResponseEntity<Employee> empResponse = null;
		try{
		empResponse = restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),Employee.class);
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return empResponse.getBody();
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	

}