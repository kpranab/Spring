/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackhive.tmsloginapp.model.Users;

/**
 * @author Pranab Kumar Sahoo
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String userName);

}
