package com.banking.demo.customerResponse;

import java.util.Date;

import com.banking.demo.entities.CustomerEntity;

public class CustomerResponseForRegistration {

	private Date timeStamp;
	private String status;
	private String message;
	private CustomerEntity customerEntity;
	
	public CustomerResponseForRegistration() {
		super();
	}

	public CustomerResponseForRegistration(Date timeStamp, String status, String message,
			CustomerEntity customerEntity) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.customerEntity = customerEntity;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@Override
	public String toString() {
		return "CustomerResponseForRegistration [timeStamp=" + timeStamp + ", status=" + status + ", message=" + message
				+ ", customerEntity=" + customerEntity + "]";
	}
	
	
}
