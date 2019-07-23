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
	@JoinTable(name = "user_role", joinColumns= @JoinColumn(name = "user_id"), inverseJoinColumns= @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Users() {
	}

	public Users(Users users){
		this.active = users.active;
		this.email = users.email;
		this.firstName = users.firstName;
		this.id = users.id;
		this.lastName = users.lastName;
		this.middleName = users.middleName;
		this.password = users.password;
		this.roles = users.roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
