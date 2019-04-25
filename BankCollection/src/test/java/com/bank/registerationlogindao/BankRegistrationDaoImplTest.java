package com.bank.registerationlogindao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.model.Account;
import com.bank.transactiondao.BankTransactionDaoImpl;

import junit.framework.Assert;

class BankRegistrationDaoImplTest {

	static Account acc;
	static BankRegistrationDaoImpl bank;
	static BankTransactionDaoImpl trans;
	
	
	
	@BeforeAll
	public static void Obj() {
		acc = new Account();
		bank = new BankRegistrationDaoImpl();
		trans=new BankTransactionDaoImpl();
		
	}

	@Test
	void testRegistration() {
		
		acc.setAadharNo(1234567891);
		acc.setAddress("hyderabad");
		acc.setEmailId("varsha07@gmail.com");
		acc.setFirstName("varsha");
		acc.setLastName("reddy");
		acc.setPassword("varsha");
		acc.setPancardNo("12345687");
		acc.setMobileNo(987654321);
		acc.setBalance(1000);
		acc.setAccountNo(987654321);
		assertEquals(987654321,bank.registration(acc));
	}

	@Test
	void testLogin() {
		
		 assertEquals(null, bank.Login(987654321,"varsha") );
		}

	@Test
	void testValidate() {
		
		 assertEquals(false, bank.validate(1234567891));
	}
	@Test
	 void testDeposit() {
	 assertEquals(1, trans.deposit(acc, 100));
	 }
	
	 @Test
	 void testWithdraw() {
	 assertEquals(1, trans.withdraw(acc, 50));
	 }


	@Test
	void testFundTransfer() {
		 assertEquals(0, bank.fundTransfer(acc, 300, 10000060, 100));
	}

}
