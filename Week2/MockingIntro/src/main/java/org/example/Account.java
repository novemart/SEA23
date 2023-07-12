package org.example;

public class Account {
	
	private ICalculator calculator;
	private double balance; 
	
	//needs a 'ICalculator' object to calculate balance
	public Account(double initBalance, ICalculator calculator){
		this.calculator = calculator;
		this.balance = initBalance;
	}
	
	public double getBalance() { 
		return this.balance; 
	}

	public void depositMoney(double amount){
		if (amount > 1000) {
			this.balance = calculator.add(balance, amount);
		}
		else{
			this.balance += amount;
		}
	}


}
