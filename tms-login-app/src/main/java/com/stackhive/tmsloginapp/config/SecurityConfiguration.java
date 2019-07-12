/**
 * 
 */
package com.stackhive.tmsloginapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("pranab").password("{noop}test").roles("ADMIN").and()
			.withUser("pramod").password("{noop}test1").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
//			.antMatchers("*/other*")
			.anyRequest()
			.fullyAuthenticated()
			.and().httpBasic();
		http.csrf().disable();
	}

	
}
