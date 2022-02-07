package com.banking.demo.customRequest;

public class OtpRequest {
	
	private String emailId;

	public OtpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpRequest(String emailId) {
		super();
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "OtpRequest [emailId=" + emailId + "]";
	}

}
