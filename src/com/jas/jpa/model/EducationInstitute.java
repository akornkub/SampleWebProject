package com.jas.jpa.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education_institute", schema = "public")
public class EducationInstitute implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String institutename;

	public EducationInstitute() {
	}

	public EducationInstitute(int id, String institutename) {
		this.id = id;
		this.institutename = institutename;
	}

	public EducationInstitute(int id, String institutename,
			Set<Education> educations) {
		this.id = id;
		this.institutename = institutename;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "institutename", nullable = false)
	public String getInstitutename() {
		return this.institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}
}
