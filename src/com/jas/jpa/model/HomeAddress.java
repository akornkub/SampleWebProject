package com.jas.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "homeaddress", schema = "public")
public class HomeAddress implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private Province province;
	private UserProfile userprofile;
	private String street1;
	private String street2;
	private Integer zipcode;

	public HomeAddress() {
	}

	public HomeAddress(int id) {
		this.id = id;
	}

	public HomeAddress(int id, Province province, UserProfile userprofile,
			String street1, String street2, Integer zipcode) {
		this.id = id;
		this.province = province;
		this.userprofile = userprofile;
		this.street1 = street1;
		this.street2 = street2;
		this.zipcode = zipcode;
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
	@JoinColumn(name = "provinceid")
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userprofileid")
	public UserProfile getUserprofile() {
		return this.userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	@Column(name = "street1")
	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	@Column(name = "street2")
	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@Column(name = "zipcode")
	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

}
