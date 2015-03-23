package com.jas.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount", schema = "public")
public class UserAccount implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;

	public UserAccount() {
	}

	public UserAccount(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 10)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
