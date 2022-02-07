package com.banking.demo.customRequest;

public class CustomRequestForMoneyTransfer {
	
	private String accountNumber;
	private String userAccountNumber;
	private long amount;
	private String branchName;
	private String ifsc;
	private String transactionPin;
	
	public CustomRequestForMoneyTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomRequestForMoneyTransfer(String accountNumber, String userAccountNumber, long amount, String branchName,
			String ifsc, String transactionPin) {
		super();
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.transactionPin = transactionPin;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getTransactionPin() {
		return transactionPin;
	}

	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}

	@Override
	public String toString() {
		return "CustomRequestForMoneyTransfer [accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", branchName=" + branchName + ", ifsc=" + ifsc
				+ ", transactionPin=" + transactionPin + "]";
	}

}
