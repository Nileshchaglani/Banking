package com.banking.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.customRequest.OtpRequest;
import com.banking.demo.customRequest.PasswordChange;
import com.banking.demo.customerResponse.CustomResponseForAccountDetails;
import com.banking.demo.customerResponse.CustomerResponseForNoUser;
import com.banking.demo.customerResponse.CustomerResponseForRegistration;
import com.banking.demo.entities.AccountDetails;
import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.service.AccountService;
import com.banking.demo.service.CustomerService;
import com.banking.demo.serviceImpl.MailService;
import com.banking.demo.util.AccountNumberGenerator;
import com.banking.demo.util.Validations;

@RestController
@CrossOrigin
@RequestMapping("/customer/auth")
public class CustomerController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Validations validation;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	

	@PostMapping("/registerCustomer")
	public ResponseEntity<Object> registerCustomer(@RequestBody CustomerEntity cust) {
		
		validation.registerCustomer(cust);
		
		CustomerEntity fetchedEmail = customerService.findUserByEmails(cust.getEmailId());
		if(fetchedEmail == null) {
			CustomerEntity regCustomer = customerService.registerCustomer(cust);
			
			AccountDetails accountDetails = new AccountDetails();
			accountDetails.setAccountNumber(regCustomer.getAccountNumber());
			accountDetails.setCustomerId(regCustomer);
			accountDetails.setBranchName("Pune");
			accountDetails.setIfsc("PARK202122");
			accountDetails.setAccountBalance(0);
			accountDetails.setStatus(regCustomer.getStatus());
			accountDetails.setCreatedAt(regCustomer.getCreatedDate());
			accountDetails.setUpdateAt(regCustomer.getUpdatedDate());
			
			customerService.addAccountDetails(accountDetails);
			
			CustomerResponseForRegistration custResponse = new CustomerResponseForRegistration(new Date(), "Customer is Registered Successfully","200", regCustomer);
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
			
		}else {
			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Customer Already Exist", "409");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<Object> loginCustomer(@RequestBody CustomerEntity cust) {
		
		validation.loginCustomer(cust);
//		passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(cust.getPassword());
//		cust.setPassword(encodedPassword);
//		System.out.print("password: "+encodedPassword);
		
		CustomerEntity fetchedEmail = customerService.findUserByEmails(cust.getEmailId());
		
		if(fetchedEmail == null) {
			CustomerResponseForNoUser loginResponse = new CustomerResponseForNoUser(new Date(), "Invalid Email or Password", "409");
			return new ResponseEntity<Object>(loginResponse, HttpStatus.OK);
		}else {
			if(passwordEncoder.matches(cust.getPassword(), fetchedEmail.getPassword()) == true) {
				CustomerResponseForNoUser loginResponse = new CustomerResponseForNoUser(new Date(), "Login Successful", "200");
				return new ResponseEntity<Object>(loginResponse, HttpStatus.OK);
			}else {
				CustomerResponseForNoUser loginResponse = new CustomerResponseForNoUser(new Date(), "Invalid Credentials", "400");
				return new ResponseEntity<Object>(loginResponse, HttpStatus.OK);
			}
			
		}
		
	}
	
	@PostMapping("/fetchAccountDetails")
	public ResponseEntity<Object> fetchAccountDetails(@RequestBody AccountDetails accountDetails){
		
		AccountDetails fetchAccount =  accountService.fetchAccountDetails(accountDetails.getAccountNumber());
		
		if(fetchAccount == null) {
			CustomResponseForAccountDetails loginResponse = new CustomResponseForAccountDetails(new Date(), "Account Not Found", "400", fetchAccount);
			return new ResponseEntity<Object>(loginResponse, HttpStatus.OK);
		}else {
			CustomResponseForAccountDetails loginResponse = new CustomResponseForAccountDetails(new Date(), "Account Details Fetched Successfully", "200", fetchAccount);
			return new ResponseEntity<Object>(loginResponse, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<Object> UpdateCustomer(@RequestBody CustomerEntity cust) {
		
		CustomerEntity userId = customerService.findUserById(cust.getCustomerId());

		if (userId != null) {
			customerService.updateCustomer(cust.getFirstName(), cust.getMiddleName(), cust.getLastName(), cust.getAddress(), cust.getCustomerId());
			
			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Customer Updated Successfully","200");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		} else {

			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Cannot find Customer by that Id","200");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<Object> UpdatePassword(@RequestBody PasswordChange passwordChange) {
		
		CustomerEntity fetchedEmail = customerService.findUserByEmails(passwordChange.getEmailId());
		
		if (fetchedEmail != null) {
			
			if (passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {
				
				if (passwordEncoder.matches(passwordChange.getConfirmPassword(), fetchedEmail.getPassword()) == true) {
					CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "New Password Should be different from old Password","400");
					return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
				}else {
					
					customerService.updatePassword(passwordChange.getConfirmPassword(), passwordChange.getEmailId());
					CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Password Updated Successfully","200");
					return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
				}
				
			}else {
				CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Confirm Password do not Match","400");
				return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
			}
		}else {
			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Invalid Email or User Does't Exist","409");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/sendOTP")
	public ResponseEntity<Object> SendOTP(@RequestBody OtpRequest otpRequest) {
		
		CustomerEntity fetchedEmail = customerService.findUserByEmails(otpRequest.getEmailId());
		if (fetchedEmail != null) {
			mailService.sendMail(otpRequest.getEmailId(), accountNumberGenerator.TransactionPin());
			
			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "OTP Send to Email","200");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		}else {
			
			CustomerResponseForNoUser custResponse = new CustomerResponseForNoUser(new Date(), "Invalid Email or User Does't Exist","409");
			return new ResponseEntity<Object>(custResponse, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerEntity> getAllCustomer() {
		return customerService.getAllCustomer();
	}
}
