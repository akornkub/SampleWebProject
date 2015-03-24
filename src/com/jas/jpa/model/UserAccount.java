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
	private String userName;
	private String password;

	public UserAccount() {
	}

	public UserAccount(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
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
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
