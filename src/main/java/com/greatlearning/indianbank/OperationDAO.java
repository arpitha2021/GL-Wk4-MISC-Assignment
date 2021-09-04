package com.greatlearning.indianbank;

import java.util.ArrayList;
import java.util.List;

public class OperationDAO {
	List<Customer> customerList = new ArrayList<Customer>();

	public OperationDAO() {
		customerList.add(new Customer(123, "password1", 1000, 1234, 9999888888L));
		customerList.add(new Customer(456, "password2", 1000, 4567, 9999888888L));
		customerList.add(new Customer(789, "password3", 1000, 7899, 9999888888L));
		customerList.add(new Customer(102, "password4", 1000, 9876, 9999888888L));
	}

	public boolean credentialVerification(Customer customer) {
		boolean loginStatus = false;
		for (Customer cust : customerList) {
			if (cust.getAccountNumber() == customer.getAccountNumber()
					&& cust.getPassword().equals(customer.getPassword())) {
				System.out.println("Login Successfull");
				loginStatus = true;
				break;
			} 

		}
		return loginStatus;
	}

	public void displayCustomerStatus(){
		System.out.println(customerList.toString());
	}
	public void depositAmount(Customer customer, int accNo, double amt) {
		customerList.forEach((tocust) -> {
			if (tocust.getAccountNumber() == accNo) {
				customerList.forEach((cust) -> {
					if (cust.getAccountNumber() == customer.getAccountNumber()) {
						if (cust.getAccountBalance() > amt) {
							tocust.setAccountBalance(cust.getAccountBalance() + amt);
							cust.setAccountBalance(cust.getAccountBalance() - amt);
							System.out.println(tocust.toString());
							System.out.println("amount " + amt + " deposit is successful");
						} else {
							System.out.println(cust.toString());
							System.out.println("Insfufficient Balance");
						}
					}
				});
			}
		});
	}

	public void withdrawAmount(Customer c, double amt) {
		customerList.forEach((cust) -> {
			if (cust.getAccountNumber() == c.getAccountNumber())
				if (cust.getAccountBalance() > amt) {
					cust.setAccountBalance(cust.getAccountBalance() - amt);
					System.out.println(cust.toString());
					System.out.println("amount " + amt + " withdrawal is successful");
				} else {
					System.out.println(cust.toString());
					System.out.println("Insufficient Balance");
				}
		});
	}

	public void transferAmount(Customer customer, double amt, int account, int otp) {
		customerList.forEach(toCustomer -> {
			if (toCustomer.getAccountNumber() == account) {
				customerList.forEach((cust) -> {
					if (cust.getAccountNumber() == customer.getAccountNumber() && cust.getOtp() == otp) {
						System.out.println("OTP Verification Successfull!!!");
						if (cust.getAccountBalance() > amt) {
							cust.setAccountBalance(cust.getAccountBalance() - amt);
							toCustomer.setAccountBalance(toCustomer.getAccountBalance()+amt);
							System.out.println("amount " + amt + " transfer is successful");
						} else {
							System.out.println("Failed transfer transaction");
						}
					}
				});
			}
		});
	}
}
