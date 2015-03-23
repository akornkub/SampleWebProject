package com.jas.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province", schema = "public")
public class Province implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String provincename;

	public Province() {
	}

	public Province(int id, String provincename) {
		this.id = id;
		this.provincename = provincename;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "provincename", nullable = false)
	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

}
