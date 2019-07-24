/**
 * 
 */
package com.stackhive.tmsloginapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stackhive.tmsloginapp.model.CustomUserDetails;
import com.stackhive.tmsloginapp.model.Users;
import com.stackhive.tmsloginapp.repository.UsersRepository;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByfirstName(userName);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
