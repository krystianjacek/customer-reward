package com.jacek.customerreward.webapp.backend.dao.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	
	@Query(value = "select t from TransactionEntity t left join t.customer c on c.id = t.customer.id  where t.customer.id = ?1 and t.date >= ?2")
	List<TransactionEntity> getLastMonthCustomerTransactions(final long customerId, final Instant instant);
	
	@Query("select t from TransactionEntity t where t.customer.id = ?1")
	List<TransactionEntity> getAllCustomerTransactions(final long customerId);
}
