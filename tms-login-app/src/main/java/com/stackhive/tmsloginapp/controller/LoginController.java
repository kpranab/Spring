/**
 * 
 */
package com.stackhive.tmsloginapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@RestController
public class LoginController {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin")
	public String adminLogin() {
		return "Admin Login successfull";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/tms")
	public String login() {
		return "Login successfull";
	}

}
