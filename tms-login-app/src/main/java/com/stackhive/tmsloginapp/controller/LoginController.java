/**
 * 
 */
package com.stackhive.tmsloginapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/login")
	public String login() {
		return "Login successfull";
	}
}
