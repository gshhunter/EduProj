package com.malihong.dao;

import com.malihong.entity.PromotionCode;

public interface PromotionCodeDao {
	public void add(PromotionCode pc);
	public void delete(PromotionCode pc);	
	public void update(PromotionCode pc);
	
	public PromotionCode getEntityByCodeAndType(String code, int type);
}
