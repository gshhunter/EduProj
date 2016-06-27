package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the e_account database table.
 * 
 */
@Entity
@Table(name="e_account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_account")
	private int idAccount;

	private String cellphone;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_time")
	private Date lastLoginTime;

	private String passwordmd5;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_time")
	private Date regTime;

	private String type;

	private String username;

	//bi-directional many-to-one association to Identification
	@OneToMany(mappedBy="EAccount")
	private List<Identification> EIdentifications;

	//bi-directional many-to-one association to Profile
	@OneToMany(mappedBy="EAccount")
	private List<Profile> EProfiles;

	public Account() {
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPasswordmd5() {
		return this.passwordmd5;
	}

	public void setPasswordmd5(String passwordmd5) {
		this.passwordmd5 = passwordmd5;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Identification> getEIdentifications() {
		return this.EIdentifications;
	}

	public void setEIdentifications(List<Identification> EIdentifications) {
		this.EIdentifications = EIdentifications;
	}

	public Identification addEIdentification(Identification EIdentification) {
		getEIdentifications().add(EIdentification);
		EIdentification.setEAccount(this);

		return EIdentification;
	}

	public Identification removeEIdentification(Identification EIdentification) {
		getEIdentifications().remove(EIdentification);
		EIdentification.setEAccount(null);

		return EIdentification;
	}

	public List<Profile> getEProfiles() {
		return this.EProfiles;
	}

	public void setEProfiles(List<Profile> EProfiles) {
		this.EProfiles = EProfiles;
	}

	public Profile addEProfile(Profile EProfile) {
		getEProfiles().add(EProfile);
		EProfile.setEAccount(this);

		return EProfile;
	}

	public Profile removeEProfile(Profile EProfile) {
		getEProfiles().remove(EProfile);
		EProfile.setEAccount(null);

		return EProfile;
	}

}