package com.cg.mypaymentapp.beans;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity

public class Wallet implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequence", name="mysgen")
	private int wallet_id;
	
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Wallet(int wallet_id, BigDecimal balance) {
		super();
		this.wallet_id = wallet_id;
		this.balance = balance;
	}

	
	
	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public int getWallet() {
		return wallet_id;
	}

	public void setWallet(int wallet) {
		wallet_id = wallet;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		if (wallet_id != other.wallet_id)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wallet [wallet=" + wallet_id + ", balance=" + balance + "]";
	}



}
