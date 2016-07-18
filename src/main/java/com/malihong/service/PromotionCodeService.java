package com.malihong.service;

import java.util.Date;

import com.malihong.entity.PromotionCode;

public interface PromotionCodeService {
	public void generateCode(int count,int length, int type, Date expiredDays);
	public void generateCode(int count,int length, int type);

	public PromotionCode validateCode(int type, String code);
	public void upadte(PromotionCode pc);
}
