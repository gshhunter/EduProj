package com.malihong.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.PromotionCodeDao;
import com.malihong.entity.PromotionCode;

@Service
@Qualifier("promotionCodeService")
public class PromotionCodeServiceImpl implements PromotionCodeService{

	@Autowired
	private PromotionCodeDao pcDao;
	@Override 
	public void generateCode(int count, int length, int type, Date expiredDays) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void generateCode(int count, int length, int type) {
		SecureRandom random = new SecureRandom();
		Date cd=new Date();
		for(int i=0;i<count;i++){
		String code=new BigInteger(length*5, random).toString(32).toUpperCase();
		//System.out.println(code+"  "+code.length());
		if(code.length()!=length){
			i--;
		}else{
			PromotionCode pc=new PromotionCode();
			pc.setCode(code);
			pc.setType(type);
			pc.setCreatedTime(cd);
			this.pcDao.add(pc);
		}
		}
	}
	@Override
	public PromotionCode validateCode(int type, String code) {
		return this.pcDao.getEntityByCodeAndType(code, type);
	}
	@Override
	public void upadte(PromotionCode pc) {
		this.pcDao.update(pc);
	}

}
