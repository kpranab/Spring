/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackhive.tmsloginapp.model.UserRole;

/**
 * @author Pranab Kumar Sahoo
 *
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	List<String> findByRole(String userName);
}
