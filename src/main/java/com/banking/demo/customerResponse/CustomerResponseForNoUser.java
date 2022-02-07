package com.banking.demo.customerResponse;

import java.util.Date;

public class CustomerResponseForNoUser {

	private Date timeStamp;
	private String message;
	private String status;
	
	public CustomerResponseForNoUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerResponseForNoUser(Date timeStamp, String message, String status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;
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

	@Override
	public String toString() {
		return "CustomerResponseForNoUser [timeStamp=" + timeStamp + ", message=" + message + ", status=" + status
				+ "]";
	}
	
	
}
