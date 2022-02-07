package com.banking.demo.service;

import com.banking.demo.entities.AccountDetails;
import com.banking.demo.entities.MoneyTransfer;

public interface AccountService {

	AccountDetails fetchAccountDetails(String accountNumber);

	int updateAccountBalance(long accountBalance, String updatedDate, String accountNumber);

	MoneyTransfer updateCreditDebit(MoneyTransfer updateCrDb);


}
