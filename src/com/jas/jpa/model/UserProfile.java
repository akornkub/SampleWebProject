package com.jas.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userprofile", schema = "public")
public class UserProfile implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private UserAccount userAccount;
	private HomeAddress homeaddress;
	private List<Education> educations = new ArrayList<Education>(0);
	private List<Job> jobs = new ArrayList<Job>(0);
	private String firstname;
	private String lastname;
	private String email;

	public UserProfile() {
	}

	public UserProfile(int id) {
		this.id = id;
	}

	public UserProfile(int id, HomeAddress homeaddress, List<Education> educations,
			List<Job> jobs, String firstname, String lastname, String email) {
		this.id = id;
		this.homeaddress = homeaddress;
		this.educations = educations;
		this.jobs = jobs;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "useraccountid")
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeaddressid")
	public HomeAddress getHomeaddress() {
		return this.homeaddress;
	}

	public void setHomeaddress(HomeAddress homeaddress) {
		this.homeaddress = homeaddress;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
