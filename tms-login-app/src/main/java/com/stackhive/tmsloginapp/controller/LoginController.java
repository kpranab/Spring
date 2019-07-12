/**
 * 
 */
package com.stackhive.tmsloginapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@RestController
@RequestMapping("/tms")
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "Login successfull";
	}
}
