package com.jacek.customerreward.webapp.backend.service.impl;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;
import com.jacek.customerreward.webapp.backend.dao.mapper.TransactionMapper;
import com.jacek.customerreward.webapp.backend.dao.repository.CustomerRepository;
import com.jacek.customerreward.webapp.backend.dao.repository.TransactionRepository;
import com.jacek.customerreward.webapp.backend.exception.UserNotFoundException;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	private final TransactionRepository transactionRepository;
	
	private final CustomerRepository customerRepository;
	
	private final TransactionMapper transactionMapper;
	
	public TransactionServiceImpl(final TransactionRepository transactionRepository,
								  final CustomerRepository customerRepository,
								  final TransactionMapper transactionMapper) {
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
		this.transactionMapper = transactionMapper;
	}
	
	@Override
	@Transactional
	public Transaction addCustomerTransaction(final Transaction transaction, final long customerId) {
		final TransactionEntity transactionEntity = TransactionEntity
				.builder()
				.price(transaction.getPrice())
				.date(transaction.getDate() != null ? transaction.getDate() : Instant.now())
				.customer(this.customerRepository.findById(customerId).orElseThrow(() -> new UserNotFoundException("User with id " + customerId + " not found!")))
				.build();
		
		return this.transactionMapper.map(this.transactionRepository.save(transactionEntity));
	}
	
	@Override
	public List<Transaction> getAllTransactions() {
		return this.transactionMapper.map(this.transactionRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Transaction> getAllCustomerTransactions(final long customerId) {
		final List<TransactionEntity> allCustomerTransactions = this.transactionRepository.getAllCustomerTransactions(customerId);
		LOGGER.debug("Found {} transactions for customer {}", allCustomerTransactions.size(), customerId);
		return this.transactionMapper.map(allCustomerTransactions);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Transaction> getLastMonthCustomerTransactions(final long customerId) {
		final List<TransactionEntity> lastMonthCustomerTransactions = this.transactionRepository.getLastMonthCustomerTransactions(customerId);
		LOGGER.debug("Found {} transactions for customer {}", lastMonthCustomerTransactions.size(), customerId);
		return this.transactionMapper.map(lastMonthCustomerTransactions);
	}
}
