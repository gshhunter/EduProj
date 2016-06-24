package com.malihong.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "eProfile")
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4835628849366933037L;

	@Id
	@Column(name = "id_profile")
	@GeneratedValue
	private int id_profile;
	
	private String surname;
	
	private String firstname;
	
	private String homeAddress;
	
	private String cityName;
	
	private String state;
	
	private int postcode;
	
	private String country;
	
	private String contact_email;
	
	private String contact_phone;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="profile")
	private Account account;
	
	public int getId_profile() {
		return id_profile;
	}

	public void setId_profile(int id_profile) {
		this.id_profile = id_profile;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
