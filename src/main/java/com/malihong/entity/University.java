package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the e_university database table.
 * 
 */
@Entity
@Table(name="e_university")
@NamedQuery(name="University.findAll", query="SELECT u FROM University u")
public class University implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_university")
	private int idUniversity;

	private String address;

	private String city;

	@Column(name="cn_name")
	private String cnName;

	private String country;

	@Column(name="en_name")
	private String enName;

	private double latitude;

	private double longitude;

	private int postcode;

	private String state;

	private String website;

	public University() {
	}

	public int getIdUniversity() {
		return this.idUniversity;
	}

	public void setIdUniversity(int idUniversity) {
		this.idUniversity = idUniversity;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCnName() {
		return this.cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}