package com.example.springaop.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addSomething() {
		System.out.println(getClass() + ": ADDING SOMETHING");
	}
}
