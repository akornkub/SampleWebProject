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
@Table(name = "userProfile", schema = "public")
public class UserProfile implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private UserAccount userAccount;
	private HomeAddress homeAddress;
	private List<Education> educations = new ArrayList<Education>(0);
	private List<Job> jobs = new ArrayList<Job>(0);
	private String firstName;
	private String lastName;
	private String email;

	public UserProfile() {
	}

	public UserProfile(int id) {
		this.id = id;
	}

	public UserProfile(int id, HomeAddress homeAddress, List<Education> educations,
			List<Job> jobs, String firstname, String lastname, String email) {
		this.id = id;
		this.homeAddress = homeAddress;
		this.educations = educations;
		this.jobs = jobs;
		this.firstName = firstName;
		this.lastName = lastName;
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
	public HomeAddress getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
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
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
