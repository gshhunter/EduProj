package com.malihong.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "eUniversity")
public class University implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4634141734900055469L;

	@Id
	@GeneratedValue
	private int id_eUni;
	
	private String cn_name;
	
	private String en_name;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int postcode;
	
	private double latitude;
	
	private double longitude;
	
	private String website;

	public int getId_eUni() {
		return id_eUni;
	}

	public void setId_eUni(int id_eUni) {
		this.id_eUni = id_eUni;
	}

	public String getCn_name() {
		return cn_name;
	}

	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}

	public String getEn_name() {
		return en_name;
	}

	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
