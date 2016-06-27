package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_profile database table.
 * 
 */
@Entity
@Table(name="e_profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profile")
	private int idProfile;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="city_name")
	private String cityName;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_phone")
	private String contactPhone;

	private String country;

	private String firstname;

	private String gender;

	@Column(name="home_address")
	private String homeAddress;

	private int postcode;

	private String state;

	private String surname;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="id_account")
	private Account EAccount;

	public Profile() {
	}

	public int getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public int getPostcode() {
		return this.postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Account getEAccount() {
		return this.EAccount;
	}

	public void setEAccount(Account EAccount) {
		this.EAccount = EAccount;
	}

}