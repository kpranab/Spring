package com.stackhive.tmsloginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackhive.tmsloginapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
