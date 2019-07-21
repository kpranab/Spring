/**
 * 
 */
package com.stackhive.tmsloginapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role")
	private String role;

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
