/**
 * 
 */
package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Creditcard;

/**
 * @author GSH1
 *
 */
public interface CreditCardDao {

	public void add(Creditcard c);
	
	public void delete(Creditcard c);
	
	public void update(Creditcard c);
	
	public List<Creditcard> findByUserId(int uid);
}
