package com.formation.model;

import java.util.*;

import javax.persistence.*;
import javax.print.attribute.HashAttributeSet;

@Entity
@Table(name="users")
public class User 
{
	@Id
	private String username;
	
	private String password;
	private boolean enable;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<UserRole>();
	
	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
}
