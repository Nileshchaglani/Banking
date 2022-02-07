package com.banking.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.demo.entities.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long>{

	@Query("SELECT acc FROM AccountDetails acc WHERE acc.accountNumber = ?1")
	AccountDetails fetchAccountDetails(String accountNumber);

	@Modifying
	@Transactional
	@Query("UPDATE AccountDetails a SET a.accountBalance = ?1, a.updateAt = ?2 WHERE a.accountNumber = ?3")
	int updateAccountBalance(long accountBalance, String updatedDate, String accountNumber);


}
