package com.jacek.customerreward.webapp.backend.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.CustomerRewardService;
import com.jacek.customerreward.webapp.backend.service.RewardPointsCalculator;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@Service
public class CustomerRewardServiceImpl implements CustomerRewardService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRewardServiceImpl.class);
	
	private final TransactionService transactionService;
	
	public CustomerRewardServiceImpl(final TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@Override
	@Transactional(readOnly = true)
	public BigInteger getLastMonthCustomerPoints(final long customerId) {
		final List<Transaction> lastMonthTransactions = this.transactionService.getLastMonthCustomerTransactions(customerId);
		final BigInteger allPoints = lastMonthTransactions
				.stream()
				.map(RewardPointsCalculator::calculatePoints).reduce(BigInteger::add).orElse(BigInteger.ZERO);
		LOGGER.debug("Customer {} received {} points in last month", customerId, allPoints);
		return allPoints;
	}
	
	@Override
	@Transactional(readOnly = true)
	public BigInteger getTotalCustomerPoints(final long customerId) {
		final List<Transaction> allTransactions = this.transactionService.getAllCustomerTransactions(customerId);
		final BigInteger allPoints = allTransactions
				.stream()
				.map(RewardPointsCalculator::calculatePoints).reduce(BigInteger::add).orElse(BigInteger.ZERO);
		LOGGER.debug("Customer {} received {} points total", customerId, allPoints);
		return allPoints;
	}
}
