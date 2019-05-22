package com.sapient.spring.service.account;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author prakumar56
 *
 */
@Entity
public class Account implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long number;
	private String name;
	private Long amount;
	
	public Account() {
		super();
	}
	
	public Account(Long number, String name, Long amount) {
		super();
		this.number = number;
		this.amount = amount;
		this.name = name;
	}
	
	public Account(String name, Long amount) {
		this.name = name;
		this.amount = amount;
	}

	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", amount=" + amount + "]";
	}
	
}