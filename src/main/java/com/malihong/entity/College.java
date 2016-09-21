package com.malihong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="uni_college")
@NamedQuery(name="College.findAll", query="SELECT c FROM College c")
public class College implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_college")
	private int collegeId;
	@Column(name="type")
	private int type;
	@Column(name="name")
	private String name;
	@Column(name="country")
	private String country;
	@Column(name="img_name")
	private String img_name;
	@Column(name="city")
	private String city;
	@Column(name="address")
	private String address;
	@Column(name="name_cn")
	private String name_cn;
	@Column(name="website")
	private String website;
	@Column(name="global_rank")
	private int global_rank;
	@Column(name="aus_rank")
	private int aus_rank;
	@Column(name="history")
	private String history;
	@Column(name="major1_cn")
	private String major1_cn;
	@Column(name="major2_cn")
	private String major2_cn;
	@Column(name="major3_cn")
	private String major3_cn;
	@Column(name="major4_cn")
	private String major4_cn;
	@Column(name="major5_cn")
	private String major5_cn;
	@Column(name="major_desc")
	private String major_desc;
	@Column(name="qs_rank")
	private String qs_rank;
	@Column(name="tuition_fee")
	private String tuition_fee;
	@Column(name="living_cost")
	private String living_cost;
	@Column(name="start_date")
	private String start_date;
	@Column(name="language_requirement")
	private String language_requirement;

	public College() {
	}

	public int getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName_cn() {
		return name_cn;
	}

	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getGlobal_rank() {
		return global_rank;
	}

	public void setGlobal_rank(int global_rank) {
		this.global_rank = global_rank;
	}

	public int getAus_rank() {
		return aus_rank;
	}

	public void setAus_rank(int aus_rank) {
		this.aus_rank = aus_rank;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getMajor1_cn() {
		return major1_cn;
	}

	public void setMajor1_cn(String major1_cn) {
		this.major1_cn = major1_cn;
	}

	public String getMajor2_cn() {
		return major2_cn;
	}

	public void setMajor2_cn(String major2_cn) {
		this.major2_cn = major2_cn;
	}

	public String getMajor3_cn() {
		return major3_cn;
	}

	public void setMajor3_cn(String major3_cn) {
		this.major3_cn = major3_cn;
	}

	public String getMajor4_cn() {
		return major4_cn;
	}

	public void setMajor4_cn(String major4_cn) {
		this.major4_cn = major4_cn;
	}

	public String getMajor5_cn() {
		return major5_cn;
	}

	public void setMajor5_cn(String major5_cn) {
		this.major5_cn = major5_cn;
	}

	public String getMajor_desc() {
		return major_desc;
	}

	public void setMajor_desc(String major_desc) {
		this.major_desc = major_desc;
	}

	public String getQs_rank() {
		return qs_rank;
	}

	public void setQs_rank(String qs_rank) {
		this.qs_rank = qs_rank;
	}

	public String getTuition_fee() {
		return tuition_fee;
	}

	public void setTuition_fee(String tuition_fee) {
		this.tuition_fee = tuition_fee;
	}

	public String getLiving_cost() {
		return living_cost;
	}

	public void setLiving_cost(String living_cost) {
		this.living_cost = living_cost;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getLanguage_requirement() {
		return language_requirement;
	}

	public void setLanguage_requirement(String language_requirement) {
		this.language_requirement = language_requirement;
	}
	
	
}
