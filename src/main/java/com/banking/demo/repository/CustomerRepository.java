package com.banking.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.demo.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

	@Query("SELECT c FROM CustomerEntity c WHERE c.emailId = ?1")
	CustomerEntity findUserByEmails(String email);

	@Query("SELECT c FROM CustomerEntity c WHERE c.accountNumber = ?1")
	CustomerEntity findUserByAccount(String accountNumber);

	@Modifying
	@Transactional
	@Query("UPDATE CustomerEntity ce SET ce.firstName = ?1, ce.middleName = ?2, ce.lastName = ?3, ce.address = ?4 WHERE ce.customerId = ?5")
	int updateCustomer(String firstName, String middleName, String lastName, String address,
			long customerId);

	@Query("SELECT id FROM CustomerEntity id WHERE id.customerId = ?1")
	CustomerEntity findUserById(long customerId);

	@Modifying
	@Transactional
	@Query("UPDATE CustomerEntity p SET p.password = ?1 WHERE p.emailId = ?2")
	int updatePassword(String confirmPassword, String emailId);
}
