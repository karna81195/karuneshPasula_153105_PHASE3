package com.cg.mypaymentapp.repo;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.util.JPAUtil;

public class WalletRepoImpl implements WalletRepo {
	Customer customer = null;
	private EntityManager entityManager;
	ArrayList<Transaction> transaction;
	
	public WalletRepoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	public boolean save(Customer customer) {
	
			entityManager.persist(customer);
		return true;
	}

	public Customer findOne(String mobileNo) {
		return entityManager.find(Customer.class, mobileNo);
	}

	@Override
	public void startTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Customer customer, Transaction transaction) {
		entityManager.merge(customer);
		entityManager.persist(transaction);
	}

	@Override
	public ArrayList<Transaction> recentTransactions(String mobileno) {
		String qstr = "select transaction from Transaction transaction where transaction.mobileno=:pmobileno";
		TypedQuery<Transaction> query = entityManager.createQuery(qstr, Transaction.class);
		query.setParameter("pmobileno", mobileno);
		return (ArrayList<Transaction>) query.getResultList();
	}
}