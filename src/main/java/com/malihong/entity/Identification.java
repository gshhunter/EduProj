package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the e_identification database table.
 * 
 */
@Entity
@Table(name="e_identification")
@NamedQuery(name="Identification.findAll", query="SELECT i FROM Identification i")
public class Identification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_identity")
	private int idIdentity;

	private String cellphone;

	private String email;

	@Column(name="is_cellphone")
	private int isCellphone;

	@Column(name="is_email")
	private int isEmail;

	@Column(name="is_passport")
	private int isPassport;

	@Column(name="is_qq")
	private int isQq;

	@Column(name="is_wechat")
	private int isWechat;

	@Column(name="is_weibo")
	private int isWeibo;

	private String passport;

	private String qq;

	private String wechat;

	private String weibo;

	@OneToOne(mappedBy="identification")
	private Account account;
	
	public Identification() {
	}

	public int getIdIdentity() {
		return this.idIdentity;
	}

	public void setIdIdentity(int idIdentity) {
		this.idIdentity = idIdentity;
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

	public int getIsCellphone() {
		return this.isCellphone;
	}

	public void setIsCellphone(int isCellphone) {
		this.isCellphone = isCellphone;
	}

	public int getIsEmail() {
		return this.isEmail;
	}

	public void setIsEmail(int isEmail) {
		this.isEmail = isEmail;
	}

	public int getIsPassport() {
		return this.isPassport;
	}

	public void setIsPassport(int isPassport) {
		this.isPassport = isPassport;
	}

	public int getIsQq() {
		return this.isQq;
	}

	public void setIsQq(int isQq) {
		this.isQq = isQq;
	}

	public int getIsWechat() {
		return this.isWechat;
	}

	public void setIsWechat(int isWechat) {
		this.isWechat = isWechat;
	}

	public int getIsWeibo() {
		return this.isWeibo;
	}

	public void setIsWeibo(int isWeibo) {
		this.isWeibo = isWeibo;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getWeibo() {
		return this.weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}