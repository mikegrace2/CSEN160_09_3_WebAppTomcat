package com.csen160.MVC3.model;

//Account.java
//Account is an Observable class that represents a bank
//account in which funds may be deposited or withdrawn.
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Account extends Observable {
	private double balance;
	private String name;

	// Account constructor
	public Account(String accountName, double openingDeposit) {
		name = accountName;
		setBalance(openingDeposit);
	}

	// set Account balance and notify observers of change
	private void setBalance(double accountBalance) {
		balance = accountBalance;
		// must call setChanged before notifyObservers to
		// indicate model has changed

		this.setChanged();
		// notify Observers that model has changed
		this.notifyObservers();
	}

	// get Account balance
	public double getBalance() {
		return balance;
	}

	// withdraw funds from Account
	public void withdraw(double amount) throws IllegalArgumentException {
		if (amount < 0)
			throw new IllegalArgumentException("Cannot withdraw negative amount");
		// update Account balance
		setBalance(getBalance() - amount);
	}

	// deposit funds in account
	public void deposit(double amount) throws IllegalArgumentException {
		if (amount < 0)
			throw new IllegalArgumentException("Cannot deposit negative amount");
		setBalance(getBalance() + amount);
	}

	public String getName() {
		return name;
	}
}