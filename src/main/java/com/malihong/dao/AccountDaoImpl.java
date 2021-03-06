package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Account;
import com.malihong.entity.ResetPwd;

@Component
public class AccountDaoImpl implements AccountDao {

	//private static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Account account) {
		em.persist(account);
	}

	@Override
	@Transactional
	public Account findById(int id) {
		Account account = (Account)em.find(Account.class, id);
		return account;
	}

	@Override
	@Transactional
	public void delete(Account account) {
		em.remove(em.merge(account));
		em.flush();
	}

	@Override
	@Transactional
	public void update(Account account) {
		System.out.println(account);
		em.merge(account);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Account findByEmail(String email) {
		String str = "SELECT a FROM Account a WHERE a.email = ?1";
		Query query = em.createQuery(str);
		query.setParameter(1, email);
		List<Account> list = query.getResultList();
		if (list.isEmpty()){
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 创建一个密码重置的链接
	 */
	@Override
	@Transactional
	public void addResetCode(ResetPwd resetPwd) {
		em.persist(resetPwd);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResetPwd findResetByCode(String code) {
		String str = "SELECT r FROM ResetPwd r WHERE r.code = ?1";
		Query query = em.createQuery(str);
		query.setParameter(1, code);
		List<ResetPwd> list = query.getResultList(); 
		if (list.isEmpty()){
			return null;
		} else {
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ResetPwd> findResetListByEmail(String email) {
		String str = "SELECT r FROM ResetPwd r WHERE r.email = ?1";
		Query query = em.createQuery(str);
		query.setParameter(1, email);
		List<ResetPwd> list = query.getResultList();
		if (list.isEmpty()){
			return null;
		} else {
			return list;
		}
	}

	@Override
	@Transactional
	public int findAgentIdByRandom() {
		String str="SELECT a FROM Account a where a.type=3 order by rand()";
		Query query = em.createQuery(str).setMaxResults(1);
		List<Account> list = query.getResultList();
		
		return list.get(0).getIdAccount();
	}
	
	
	
}
