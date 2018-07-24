package com.cg.mypaymentapp.beans;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "Customers")

public class Customer implements Serializable{

	@Id
	private String mobileNo;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wallet_id")
	private Wallet wallet;
	
	
	public Customer() {
		super();
	}
	public Customer(String name2, String mobileNo, Wallet wallet) {
		this.name=name2;
		this.mobileNo=mobileNo;
		this.wallet=wallet;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo
				 + wallet;
	}
	
	
}


