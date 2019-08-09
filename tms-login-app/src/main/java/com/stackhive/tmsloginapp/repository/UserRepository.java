/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackhive.tmsloginapp.model.User;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}