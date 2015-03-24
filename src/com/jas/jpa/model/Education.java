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
	private UserProfile userProfile;
	private String qualification;
	private Integer fromYear;
	private Integer toYear;

	public Education() {
	}

	public Education(int id, String qualification) {
		this.id = id;
		this.qualification = qualification;
	}

	public Education(int id, EducationInstitute educationInstitute,
			UserProfile userProfile, String qualification, Integer fromYear,
			Integer toYear) {
		this.id = id;
		this.educationInstitute = educationInstitute;
		this.userProfile = userProfile;
		this.qualification = qualification;
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
	@JoinColumn(name = "educationinstituteid")
	public EducationInstitute getEducationInstitute() {
		return this.educationInstitute;
	}

	public void setEducationInstitute(EducationInstitute educationInstitute) {
		this.educationInstitute = educationInstitute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userprofileid")
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "qualification", nullable = false)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name = "fromYear")
	public Integer getFromYear() {
		return this.fromYear;
	}

	public void setFromYear(Integer fromYear) {
		this.fromYear = fromYear;
	}

	@Column(name = "toYear")
	public Integer getToYear() {
		return this.toYear;
	}

	public void setToYear(Integer toYear) {
		this.toYear = toYear;
	}

}
