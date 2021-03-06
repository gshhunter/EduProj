package com.malihong.bean;

import java.util.Date;

public class UserProfile {

	private int id;
	
	private String email;
	
	private String cellphone;
	
	private String firstname;
	
	private String lastname;
	
	private String country;
	
	private String eng_country;
	
	private String state;
	
	private String city;
	
	private String address;
	
	private int postcode;
	
	private String weibo;
	
	private String qq;
	
	private String wechat;
	
	private String description;
	
	private Date birthday;
	
	//0: invalid 1: normal user 2: applying agent 3: agent
	private int userType;
	
	private int isEmail;
	
	private int isCellphone;
	
	private int isPassport;
	
	private int isWeibo;
	
	private int isWechat;
	
	private int isQq;
	
	private Date regTime;
	
	private int gender;
	
	private int privacy_setting;
	
	private int security_setting;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getEng_country() {
		return eng_country;
	}

	public void setEng_country(String eng_country) {
		this.eng_country = eng_country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(int isEmail) {
		this.isEmail = isEmail;
	}

	public int getIsCellphone() {
		return isCellphone;
	}

	public void setIsCellphone(int isCellphone) {
		this.isCellphone = isCellphone;
	}

	public int getIsPassport() {
		return isPassport;
	}

	public void setIsPassport(int isPassport) {
		this.isPassport = isPassport;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public int getIsWeibo() {
		return isWeibo;
	}

	public void setIsWeibo(int isWeibo) {
		this.isWeibo = isWeibo;
	}

	public int getIsWechat() {
		return isWechat;
	}

	public void setIsWechat(int isWechat) {
		this.isWechat = isWechat;
	}

	public int getIsQq() {
		return isQq;
	}

	public void setIsQq(int isQq) {
		this.isQq = isQq;
	}

	public int getPrivacy_setting() {
		return privacy_setting;
	}

	public void setPrivacy_setting(int privacy_setting) {
		this.privacy_setting = privacy_setting;
	}

	public int getSecurity_setting() {
		return security_setting;
	}

	public void setSecurity_setting(int security_setting) {
		this.security_setting = security_setting;
	}
	
	
}
