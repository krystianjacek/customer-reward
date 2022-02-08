package com.jacek.customerreward.webapp.backend.service;

import java.util.List;

import com.jacek.customerreward.webapp.backend.model.Transaction;

public interface TransactionService {
	
	Transaction addCustomerTransaction(final Transaction transaction, final long customerId);
	
	List<Transaction> getAllTransactions();
	
	List<Transaction> getAllCustomerTransactions(final long customerId);
	
	List<Transaction> getLastMonthCustomerTransactions(final long customerId);
}
