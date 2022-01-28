package com.jacek.customerreward.webapp.backend.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;
import com.jacek.customerreward.webapp.backend.dao.mapper.CustomerMapper;
import com.jacek.customerreward.webapp.backend.dao.mapper.TransactionMapper;
import com.jacek.customerreward.webapp.backend.dao.repository.CustomerRepository;
import com.jacek.customerreward.webapp.backend.dao.repository.TransactionRepository;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	private final TransactionRepository transactionRepository;
	
	private final CustomerRepository customerRepository;
	
	private final TransactionMapper transactionMapper;
	
	private final CustomerMapper customerMapper;
	
	public TransactionServiceImpl(final TransactionRepository transactionRepository,
								  final CustomerRepository customerRepository,
								  final TransactionMapper transactionMapper,
								  final CustomerMapper customerMapper) {
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
		this.transactionMapper = transactionMapper;
		this.customerMapper = customerMapper;
	}
	
	@Override
	@Transactional
	public void addCustomerTransaction(final Transaction transaction, final long customerId) {
//				final Customer customer = this.customerMapper.map(this.customerRepository.getOne(customerId));
		final TransactionEntity transactionEntity = TransactionEntity.TransactionEntityBuilder
				.newInstance()
				.price(transaction.getPrice())
				.customer(this.customerRepository.getOne(customerId))
				.build();
//		transactionEntity.setCustomer(this.customerRepository.getOne(customerId));
		//		customer.addTransaction(transaction);
		this.transactionRepository.save(transactionEntity);
		//		this.transactionRepository.
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
