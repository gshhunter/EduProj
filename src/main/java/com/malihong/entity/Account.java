package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.Date;

/**
 * The persistent class for the e_account database table.
 * @author GSH1
 * Account与Identification和Profile都是一对一关系
 * 
 */

@Entity
@Table(name="e_account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_account")
	private int idAccount;

	private String cellphone;
	
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_time")
	private Date lastLoginTime;
	
	@Column(name="passwordmd5")
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_time")
	private Date regTime;

	private int type;

	private String firstname;
	
	private String lastname;
	
	@Column(name="security_setting")
	private int security_setting;
	
	@Column(name="privacy_setting")
	private int privacy_setting;
	
	@OneToOne(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="id_profile")
	private Profile profile;
	
	@OneToOne(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="id_identity")
	private Identification identification;
	
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public int getSecurity_setting() {
		return security_setting;
	}

	public void setSecurity_setting(int security_setting) {
		this.security_setting = security_setting;
	}

	public int getPrivacy_setting() {
		return privacy_setting;
	}

	public void setPrivacy_setting(int privacy_setting) {
		this.privacy_setting = privacy_setting;
	}

	
}