/**
 * 
 */
package com.rnd.springboot.jpa.exception;

/**
 * @author Pranab Kumar Sahoo
 *
 */
public class StudentNotFoundException extends Exception{
	
	private String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public StudentNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
