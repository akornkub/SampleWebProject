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
	private UserProfile userProfile;
	private String position;
	private Integer fromYear;
	private Integer toYear;

	public Job() {
	}

	public Job(int id, String position) {
		this.id = id;
		this.position = position;
	}

	public Job(int id, UserProfile userProfile, String position,
			Integer fromYear, Integer toYear) {
		this.id = id;
		this.userProfile = userProfile;
		this.position = position;
		this.fromYear = fromYear;
		this.toYear = toYear;
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
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "position", nullable = false)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "fromyear")
	public Integer getFromYear() {
		return this.fromYear;
	}

	public void setFromYear(Integer fromYear) {
		this.fromYear = fromYear;
	}

	@Column(name = "toyear")
	public Integer getToYear() {
		return this.toYear;
	}

	public void setToYear(Integer toYear) {
		this.toYear = toYear;
	}
}
