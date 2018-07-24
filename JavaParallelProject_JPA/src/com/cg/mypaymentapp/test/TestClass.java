package com.cg.mypaymentapp.test;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;


public class TestClass 
{
	static WalletService walletService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		walletService = new WalletServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		walletService = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	 Map<String,Customer> data= new HashMap<String, Customer>();
	WalletService service;
	
	@Before
	/*public void initData()
	{
		
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
		 
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
			service= new WalletServiceImpl(data);
			
	}*/
	
	@Test(expected =InvalidInputException.class)
	public void test1()
	{
		Customer customer=walletService.createAccount(null, null, null);
		assertNotNull(customer);
	}
	
	@Test(expected =InvalidInputException.class)
	public void test2()
	{
		Customer customer=walletService.createAccount("karthik", null, null);
		assertNotNull(customer);
	}
	
	@Test(expected =InvalidInputException.class)
	public void test3()
	{
		Customer customer=walletService.createAccount(null, "9876543210", null);
		assertNotNull(customer);
	}
	
	@Test(expected =InvalidInputException.class)
	public void test4()
	{
		Customer customer=walletService.createAccount(null, null, new BigDecimal(9000));
		assertNotNull(customer);
	}
	
	@Test(expected =InsufficientBalanceException.class)
	public void test5()
	{
		Customer customer=walletService.createAccount("karthik", "9807898765", new BigDecimal(-9000));
		assertNotNull(customer);
	}
	
	
	//SHOWBALANCE junit test cases
	
	@Test(expected =InsufficientBalanceException.class)
	public void test6()
	{
		Customer customer=walletService.showBalance(null);
		assertNotNull(customer);
	}
	
	//FUNDTRANSFER junit test cases
	
	@Test(expected =InsufficientBalanceException.class)
	public void test7()
	{
		Customer customer=walletService.fundTransfer("9874456332", "9807898765", new BigDecimal(0));
		assertNotNull(customer.getWallet().getBalance());
	}
	
	
}
