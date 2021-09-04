package com.greatlearning.indianbank;

public class Customer {
	public Integer accountNumber;
	public String password;
	public double accountBalance;
	public int otp;
	public long phoneNumber;
	public Customer(){
		
	}
	public Customer(int accountNumber, String password, double accountBalance, int otp, long phoneNumber) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.accountBalance = accountBalance;
		this.otp = otp;
		this.phoneNumber = phoneNumber;
	}
	public Customer(int accountNumber, String password) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getOtp() {
		return otp;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	
	
	
}
