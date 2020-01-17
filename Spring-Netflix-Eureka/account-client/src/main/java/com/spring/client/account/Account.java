package com.spring.client.account;

import java.io.Serializable;

/**
 * @author prakumar56
 *
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long amount;
	private String number;
	private String name;

	public Account() {
		super();
	}

	public Account(Long amount, String number, String name) {
		super();
		this.amount = amount;
		this.number = number;
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + ", number=" + number + ", name=" + name + "]";
	}
}