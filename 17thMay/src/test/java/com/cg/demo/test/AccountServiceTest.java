package com.cg.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import com.cg.demo.beans.Account;
import com.cg.demo.exceptions.InsufficientBalanceException;
import com.cg.demo.exceptions.InvalidAccountException;
import com.cg.demo.repo.AccountRepo;
import com.cg.demo.service.AccountService;
import com.cg.demo.service.AccountServiceImpl;


public class AccountServiceTest {

	private AccountService service;
	@Mock private AccountRepo repo;

	@Before
	public void init(){

		MockitoAnnotations.initMocks(this);
		service= new AccountServiceImpl(repo);
	}
	/*************************
	 *  Test cases for createAccount
	 * **********************/
	// Customer object reference should not be null
	// Amount should be greater than 500 otherwise throw InvalidInitialAmountException
	// Account should be create successfully

	/*************************************************
	 *  Test cases for showBalance	
	 * @throws InvalidAccountException 
	 */
	// Account number should be valid
	// It should return balance for valid accounts

	@Test(expected=com.cg.demo.exceptions.InvalidAccountException.class)
	public void test_valid_account_number() throws InvalidAccountException{
		when(repo.findByNumber(5)).thenReturn(null);
		service.showBalance(5);
	}

	@Test
	public void test_showbalance(){
		Account a = new Account(3);
		a.setBalance(1000);
		when(repo.findByNumber(3)).thenReturn(a);
		try {
			double balance=service.showBalance(3);
			assertEquals(1000.00+"", balance+"");
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	/**********************************************************
	 * 
	 *  Test cases for withdraw	
	 * @throws InsufficientBalanceException 
	 * @throws InvalidAccountException 
	 */

	// Account number should be valid
	// amount passed should not be negative
	// amount should be less than balance 
	// if account number and amount are valid then it should deduct the balance.


	@Test(expected=com.cg.demo.exceptions.InvalidAccountException.class)
	public void withdrawShouldThrowInvalidAccountNumberIfAccountNumberIsNotValid() throws InvalidAccountException, InsufficientBalanceException{

		when(repo.findByNumber(4)).thenReturn(null);

		service.withdraw(4,1000);
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void ifAmountPassedToWithdrawIsNegativeThenItShouldThrowException() throws InvalidAccountException, InsufficientBalanceException{
		service.withdraw(3, -8765);
	}

	@Test(expected=com.cg.demo.exceptions.InsufficientBalanceException.class)

	public void ifAmountPassedIsGreaterThanBalanceThenWithdrawShouldThrowException() throws InvalidAccountException, InsufficientBalanceException{
		Account a = new Account(5);
		a.setBalance(4000);
		when(repo.findByNumber(5)).thenReturn(a);

		service.withdraw(5, 5000);

	}

	@Test
	public void whenAmountAndAccountNumberAreValidWithdrawShouldDeductTheBalance(){
		Account a = new Account(5);
		a.setBalance(4000);
		when(repo.findByNumber(5)).thenReturn(a);

		try {
			assertEquals(3500.0+"", service.withdraw(5, 500).getBalance()+"");
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/*
	 * Test cases for deposit
	 */

	// Account should be valid
	// amount should not be greater than zero
	// After deposit balance should be increased.



}












