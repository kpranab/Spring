/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackhive.tmsloginapp.model.Role;

/**
 * @author Pranab Kumar Sahoo
 *
 */
public interface UserRoleRepository extends JpaRepository<Role, Long>{

	List<String> findByRole(String userName);
}
