package com.cg.demo.beans;

public class Account {
	private int number;
	private double balance;
	private Customer customer;
	public Account(int number) {
		super();
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getNumber() {
		return number;
	}
	
	

}
