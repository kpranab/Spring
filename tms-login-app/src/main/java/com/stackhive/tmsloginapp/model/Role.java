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
}
