package com.malihong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="e_reset_pwd")
public class ResetPwd implements Serializable{

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reset")
	private String idReset;
	
	@Column(name="uuid_key")
	private String code;
	
	@Column(name="send_time")
	private long sendTime;

	@Column(name="email")
	private String email;
	

	public String getIdReset() {
		return idReset;
	}

	public void setIdReset(String idReset) {
		this.idReset = idReset;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	public long getSendTime() {
		return sendTime;
	}

	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
