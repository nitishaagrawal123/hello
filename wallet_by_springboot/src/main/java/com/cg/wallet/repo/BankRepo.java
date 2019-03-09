package com.cg.wallet.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.beans.PrintTransactions;

import oracle.net.aso.s;

@Repository
@Transactional
public class BankRepo implements IBankRepo {
	
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	/*
	 * public BankRepo() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oracle-JPA-PU");
		em = emf.createEntityManager();
	}
*/

	@Override
	public Customer createAccount(Customer c) {
	
		em.persist(c);
		return c;
	}

	@Override
	public Customer getAccount(String mobileno) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Customer cShow = em.find(Customer.class, mobileno);
		em.getTransaction().commit();
		return cShow;
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Customer cShow = em.find(Customer.class, mobileNo);
		cShow.setAmount(amount);
		em.merge(cShow);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public double showBalance(String mobileno) {
		Customer cShow = em.find(Customer.class,mobileno);
		return cShow.getAmount();
		
		
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) {
	
		Customer source = em.find(Customer.class, sourceMobileNo);
		Customer target = em.find(Customer.class, targetMobileNo);
	
		source.setAmount(source.getAmount()-amount);
		target.setAmount(target.getAmount()+amount);
		
		em.merge(source);
		em.merge(target);
		
		
		
		return target;
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) {
		Customer source = em.find(Customer.class, mobileNo);
		source.setAmount(source.getAmount()+amount);
		return source;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) {
		Customer source = em.find(Customer.class, mobileNo);
		source.setAmount(source.getAmount()-amount);
		return source;
	}
/*
	public List<PrintTransactions> getTransactions(String mobileNo) {
		// TODO Auto-generated method stub
		List<PrintTransactions> tranList = null;
		em.getTransaction().begin();
		Query query = em.createQuery("from PrintTransactions where mobileNumber = :mobNo");
		query.setParameter("mobNo", mobileNo);
		tranList = query.getResultList();
		em.getTransaction().commit();
		return tranList;
	}

	public void loadTransaction(PrintTransactions pt) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(pt);
		em.getTransaction().commit();
	}
*/
}
