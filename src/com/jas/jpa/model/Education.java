package com.jas.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "education", schema = "public")
public class Education implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private EducationInstitute educationInstitute;
	private UserProfile userprofile;
	private String qualification;
	private Integer fromyear;
	private Integer toyear;

	public Education() {
	}

	public Education(int id, String qualification) {
		this.id = id;
		this.qualification = qualification;
	}

	public Education(int id, EducationInstitute educationInstitute,
			UserProfile userprofile, String qualification, Integer fromyear,
			Integer toyear) {
		this.id = id;
		this.educationInstitute = educationInstitute;
		this.userprofile = userprofile;
		this.qualification = qualification;
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
	@JoinColumn(name = "educationinstituteid")
	public EducationInstitute getEducationInstitute() {
		return this.educationInstitute;
	}

	public void setEducationInstitute(EducationInstitute educationInstitute) {
		this.educationInstitute = educationInstitute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userprofileid")
	public UserProfile getUserprofile() {
		return this.userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	@Column(name = "qualification", nullable = false)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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
