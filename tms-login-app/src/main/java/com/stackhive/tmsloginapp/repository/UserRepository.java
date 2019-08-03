/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackhive.tmsloginapp.model.User;

/**
 * @author Pranab Kumar Sahoo
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	  User findByUserName(String email);

}
