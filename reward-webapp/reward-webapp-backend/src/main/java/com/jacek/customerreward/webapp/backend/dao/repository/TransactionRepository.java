package com.jacek.customerreward.webapp.backend.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	
	@Query("select t from TransactionEntity t where t.customer.id = ?1 and t.date <= now()")
	List<TransactionEntity> getLastMonthCustomerTransactions(final long customerId);
	
	@Query("select t from TransactionEntity t where t.customer.id = ?1")
	List<TransactionEntity> getAllCustomerTransactions(final long customerId);
}
