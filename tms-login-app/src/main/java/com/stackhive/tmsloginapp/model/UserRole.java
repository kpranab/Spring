/**
 * 
 */
package com.stackhive.tmsloginapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Entity
@Table(name = "user_role", uniqueConstraints = { //
		@UniqueConstraint(name = "uni_USER_NAME_role", columnNames = {  "USER_NAME" ,"role" }) })
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "user_role_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_NAME", nullable = false)
	private User user;
	
	@Column(name = "role", nullable = false)
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
