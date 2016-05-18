package com.cg.demo.repo;

import com.cg.demo.beans.Account;

public interface AccountRepo {

	boolean save(Account a);
	
	Account findByNumber(int number);
}
