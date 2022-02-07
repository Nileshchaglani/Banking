package com.banking.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String aadharNumber;
	private String panNumber;
	private String dateOfBirth;
	private String address;
	private String mobileNumber;
	private String emailId;
	private String password;
	private String accountNumber;
	private String transPin;
	private String status;
	private String createdDate;
	private String updatedDate;
	
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(long customerId, String firstName, String middleName, String lastName, String aadharNumber,
			String panNumber, String dateOfBirth, String address, String mobileNumber, String emailId, String password,
			String accountNumber, String transPin, String status, String createdDate, String updatedDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.accountNumber = accountNumber;
		this.transPin = transPin;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransPin() {
		return transPin;
	}

	public void setTransPin(String transPin) {
		this.transPin = transPin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", password=" + password + ", accountNumber=" + accountNumber + ", transPin="
				+ transPin + ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", getCustomerId()=" + getCustomerId() + ", getFirstName()=" + getFirstName() + ", getMiddleName()="
				+ getMiddleName() + ", getLastName()=" + getLastName() + ", getAadharNumber()=" + getAadharNumber()
				+ ", getPanNumber()=" + getPanNumber() + ", getDateOfBirth()=" + getDateOfBirth() + ", getAddress()="
				+ getAddress() + ", getMobileNumber()=" + getMobileNumber() + ", getEmailId()=" + getEmailId()
				+ ", getPassword()=" + getPassword() + ", getAccountNumber()=" + getAccountNumber() + ", getTransPin()="
				+ getTransPin() + ", getStatus()=" + getStatus() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getUpdatedDate()=" + getUpdatedDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
