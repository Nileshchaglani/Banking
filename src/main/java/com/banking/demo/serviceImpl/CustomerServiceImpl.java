package com.banking.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.demo.entities.AccountDetails;
import com.banking.demo.entities.CustomerEntity;
import com.banking.demo.repository.AccountDetailsRepository;
import com.banking.demo.repository.CustomerRepository;
import com.banking.demo.service.CustomerService;
import com.banking.demo.util.AccountNumberGenerator;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	AccountNumberGenerator accountNumberGenerator;

	@Override
	public CustomerEntity registerCustomer(CustomerEntity cust) {
//		passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(cust.getPassword());
		cust.setPassword(passwordEncoder.encode(cust.getPassword()));
		cust.setAccountNumber(""+accountNumberGenerator.AccountNumber());
		cust.setStatus("1");
		cust.setCreatedDate(""+new Date());
		cust.setUpdatedDate(""+new Date());
		cust.setTransPin(""+accountNumberGenerator.TransactionPin());
		return customerRepository.save(cust);
	}

	@Override
	public List<CustomerEntity> getAllCustomer() {
		return (List<CustomerEntity>) customerRepository.findAll();
	}

	@Override
	public CustomerEntity findUserByEmails(String email) {
		return customerRepository.findUserByEmails(email);
	}

	@Override
	public AccountDetails addAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}

	@Override
	public CustomerEntity findUserByAccount(String accountNumber) {
		return customerRepository.findUserByAccount(accountNumber);
	}

	@Override
	public int updateCustomer(String firstName, String middleName, String lastName, String address,
			long customerId) {
		return customerRepository.updateCustomer(firstName, middleName, lastName, address, customerId);
	}

	@Override
	public CustomerEntity findUserById(long customerId) {
		return customerRepository.findUserById(customerId);
	}

	@Override
	public int updatePassword(String confirmPassword, String emailId) {
		return customerRepository.updatePassword(passwordEncoder.encode(confirmPassword), emailId);
	}
	
}
