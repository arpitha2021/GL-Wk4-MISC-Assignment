package com.greatlearning.indianbank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndiaBankOperation {

	public static void main(String[] args) {
		double amount;
		int accNo;
		int toAccNo;
		int operation;
		FileWriter fileWriter = null;
		String auditMessage;
		try {
			 fileWriter = new FileWriter(new File("trasactions.txt"));
		
		System.out.println("Welcome to the Login Page");
		System.out.println("Enter the BankAccount Number");
		Scanner scanner = new Scanner(System.in);
		accNo = scanner.nextInt();
		System.out.println("Enter the password for the corresponding Bank Acc Number");
		String password = scanner.next();

		OperationDAO operationDAO = new OperationDAO();
		if (operationDAO.credentialVerification(new Customer(accNo, password))) {
			System.out.println("!!!!! Welcome to Indian Bank !!!!");
			System.out.println("--------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			boolean login=true;
			while(login){
			System.out.println("\n");
			operationDAO.displayCustomerStatus();
			
			System.out.println("\n1. Deposit\n 2.Withdrawal\n 3.Tranfer\n 0.Logout\n");
			operation = scanner.nextInt();
			switch (operation) {
			case 1:
				System.out.println("Enter the amount and account you want to deposit");
				amount = scanner.nextDouble();
				toAccNo=scanner.nextInt();
				operationDAO.depositAmount(new Customer(accNo, password), toAccNo, amount);
				auditMessage = "amount deposit transaction";
				fileWriter.append(auditMessage+"\n");
				break;
			case 2:
				System.out.println("Enter the amount you want to withdraw");
				amount = scanner.nextDouble();
				operationDAO.withdrawAmount(new Customer(accNo, password), amount);
				auditMessage = "amount withdrawal transaction";
				fileWriter.append(auditMessage+"\n");
				break;
			case 3:
				System.out.println("Enter the amount and account number you want to transfer");
				amount = scanner.nextDouble();
				toAccNo = scanner.nextInt();
				System.out.println("Enter the OTP");
				int otp = scanner.nextInt();
				auditMessage = "amount transfer transaction";
				operationDAO.transferAmount(new Customer(accNo, password), amount, toAccNo,otp);
				fileWriter.append(auditMessage+"\n");
				
				break;
			case 0:
				login=false;
				System.out.println("Exited Sucessfull");
				scanner.close();
				fileWriter.close();
				break;
			}
		}
		}else {
			System.out.println("Invalid Credentials");
		}

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
