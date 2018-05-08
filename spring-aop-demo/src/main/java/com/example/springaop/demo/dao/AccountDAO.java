package com.example.springaop.demo.dao;

import org.springframework.stereotype.Component;

import com.example.springaop.demo.Account;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with 1 account param");
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with 1 account param and a boolean flag");
	}
	
	public void addSomething() {
		System.out.println(getClass() + ": ADDING SOMETHING");
	}
}
