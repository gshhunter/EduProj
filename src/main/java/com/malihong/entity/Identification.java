package com.malihong.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "eIdentification")
public class Identification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8328505150390339336L;

	@Id
	@Column(name = "id_identity")
	@GeneratedValue
	private int id_identity;
	
	private String qq;
	
	private int is_qq;
	
	private String weibo;
	
	private int is_weibo;
	
	private String wechat;
	
	private int is_wechat;
	
	private String passport;
	
	private int is_passport;
	
	private String cellphone;
	
	private int is_cellphone;
	
	private String email;
	
	private int is_email;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="identity")
	private Account account;
	
	public int getId_identity() {
		return id_identity;
	}

	public void setId_identity(int id_identity) {
		this.id_identity = id_identity;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getIs_qq() {
		return is_qq;
	}

	public void setIs_qq(int is_qq) {
		this.is_qq = is_qq;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public int getIs_weibo() {
		return is_weibo;
	}

	public void setIs_weibo(int is_weibo) {
		this.is_weibo = is_weibo;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public int getIs_wechat() {
		return is_wechat;
	}

	public void setIs_wechat(int is_wechat) {
		this.is_wechat = is_wechat;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getIs_passport() {
		return is_passport;
	}

	public void setIs_passport(int is_passport) {
		this.is_passport = is_passport;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getIs_cellphone() {
		return is_cellphone;
	}

	public void setIs_cellphone(int is_cellphone) {
		this.is_cellphone = is_cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIs_email() {
		return is_email;
	}

	public void setIs_email(int is_email) {
		this.is_email = is_email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
