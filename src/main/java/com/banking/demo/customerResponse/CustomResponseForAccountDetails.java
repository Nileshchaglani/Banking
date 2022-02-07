package com.banking.demo.customerResponse;

import java.util.Date;

import com.banking.demo.entities.AccountDetails;

public class CustomResponseForAccountDetails {

	private Date timeStamp;
	private String message;
	private String status;
	private AccountDetails accountDetails;
	
	public CustomResponseForAccountDetails() {
		super();
	}

	public CustomResponseForAccountDetails(Date timeStamp, String message, String status,
			AccountDetails accountDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;
		this.accountDetails = accountDetails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	@Override
	public String toString() {
		return "CustomResponseForAccountDetails [timeStamp=" + timeStamp + ", message=" + message + ", status=" + status
				+ ", accountDetails=" + accountDetails + "]";
	}
	
}
