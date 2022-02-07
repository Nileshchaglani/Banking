package com.banking.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private CustomerEntity customerId;
	
	private String accountNumber;
	private String branchName;
	private String ifsc;
	private long accountBalance;
	private String status;
	private String createdAt;
	private String updateAt;
	
	public AccountDetails() {
		super();
	}

	public AccountDetails(long id, CustomerEntity customerId, String accountNumber, String branchName, String ifsc,
			long accountBalance, String status, String createdAt, String updateAt) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.accountBalance = accountBalance;
		this.status = status;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", branchName=" + branchName + ", ifsc=" + ifsc + ", accountBalance=" + accountBalance + ", status="
				+ status + ", createdAt=" + createdAt + ", updateAt=" + updateAt + "]";
	}

}
