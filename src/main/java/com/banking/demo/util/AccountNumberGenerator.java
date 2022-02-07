package com.banking.demo.util;

import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class AccountNumberGenerator {
	
	public long AccountNumber() {
		Random random = new Random();
		long accNumber = (long)(100000000000L + random.nextFloat() * 900000000000L);
		return accNumber;
	}
	
	public int TransactionPin() {
		Random random = new Random();
		int transId = 1000 + random.nextInt(999);
		return transId;
	}
	
}
