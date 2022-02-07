package com.banking.demo.util;

import org.springframework.stereotype.Service;

import com.banking.demo.entities.AccountDetails;
import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.exception.InvalidRequestException;

@Service
public class Validations {

	public void registerCustomer(CustomerEntity cust) {
		
		if(cust.getFirstName().equals("")) {
			throw new InvalidRequestException("First Name Should not be Empty");
		}
		
		if(cust.getAadharNumber().length() != 12) {
			throw new InvalidRequestException("Enter a Valid Aadhar Number");
		}
		
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
		
		if(cust.getEmailId().matches(emailRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Email");
		}
		
		String mobileRegex = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
		
		if(cust.getMobileNumber().matches(mobileRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Mobile Number");
		}
		
	}

	public void loginCustomer(CustomerEntity cust) {
		
		if(cust.getEmailId().equals("")) {
			throw new InvalidRequestException("Email Id should not be Empty");
		}
		if(cust.getPassword().equals("")) {
			throw new InvalidRequestException("Password should not be Empty");
		}
		
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
		
		if(cust.getEmailId().matches(emailRegex) == false) {
			throw new InvalidRequestException("Enter a Valid Email");
		}
		
	}

	public void balanceValidation(AccountDetails accountDetails) {
		
		if(accountDetails.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Account Number should not be Empty");
		}
		
		if(accountDetails.getAccountBalance() <= 0) {
			throw new InvalidRequestException("Enter a valid Amount");
		}
		
	}


}
