/**
 * 
 */
package com.stackhive.tmsloginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackhive.tmsloginapp.model.Role;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
