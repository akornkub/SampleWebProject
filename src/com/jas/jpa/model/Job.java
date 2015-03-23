package com.jas.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job", schema = "public")
public class Job implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private UserProfile userprofile;
	private String position;
	private Integer fromyear;
	private Integer toyear;

	public Job() {
	}

	public Job(int id, String position) {
		this.id = id;
		this.position = position;
	}

	public Job(int id, UserProfile userprofile, String position,
			Integer fromyear, Integer toyear) {
		this.id = id;
		this.userprofile = userprofile;
		this.position = position;
		this.fromyear = fromyear;
		this.toyear = toyear;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userprofileid")
	public UserProfile getUserprofile() {
		return this.userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	@Column(name = "position", nullable = false)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "fromyear")
	public Integer getFromyear() {
		return this.fromyear;
	}

	public void setFromyear(Integer fromyear) {
		this.fromyear = fromyear;
	}

	@Column(name = "toyear")
	public Integer getToyear() {
		return this.toyear;
	}

	public void setToyear(Integer toyear) {
		this.toyear = toyear;
	}
}
