/**
 * 
 */
package com.stackhive.tmsloginapp.model;

import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Entity
@Table(name="user")
public class Users {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name= "active")
	private int active;
	
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns= @JoinColumn(name = ""))
	private Set<Role> roles;
	
}
