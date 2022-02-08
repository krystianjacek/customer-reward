package com.jacek.customerreward.webapp.backend.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.Period;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jacek.customerreward.webapp.backend.model.Customer;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.CustomerRewardService;
import com.jacek.customerreward.webapp.backend.service.CustomerService;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@SpringBootTest
@Transactional
class CustomerRewardServiceImplTest {
	
	@Autowired
	CustomerRewardService customerRewardService;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void shouldReturnZeroMonthlyPoint() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction transaction = Transaction.builder().date(Instant.now()).price(new BigDecimal("10.10")).build();
		this.transactionService.addCustomerTransaction(transaction, persistedCustomer.getId());
		
		//when
		final BigInteger lastMonthCustomerPoints = this.customerRewardService.getLastMonthCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(BigInteger.ZERO, lastMonthCustomerPoints);
	}
	
	@Test
	public void shouldReturnZeroTotalPoint() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction transaction = Transaction.builder().date(Instant.now().minus(Period.ofDays(40))).price(new BigDecimal("10.10")).build();
		this.transactionService.addCustomerTransaction(transaction, persistedCustomer.getId());
		
		//when
		final BigInteger totalCustomerPoints = this.customerRewardService.getTotalCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(BigInteger.ZERO, totalCustomerPoints);
	}
	
	@Test
	public void shouldReturnCorrectMonthlySinglePoints() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction firstTransaction = Transaction.builder().date(Instant.now()).price(new BigDecimal("55.55")).build();
		final Transaction secondTransaction = Transaction.builder().date(Instant.now().minus(Period.ofDays(40))).price(new BigDecimal("65.55")).build();
		this.transactionService.addCustomerTransaction(firstTransaction, persistedCustomer.getId());
		this.transactionService.addCustomerTransaction(secondTransaction, persistedCustomer.getId());
		
		//when
		final BigInteger lastMonthCustomerPoints = this.customerRewardService.getLastMonthCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(new BigInteger("5"), lastMonthCustomerPoints);
	}
	
	@Test
	public void shouldReturnCorrectTotalSinglePoints() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction firstTransaction = Transaction.builder().date(Instant.now()).price(new BigDecimal("55.55")).build();
		final Transaction secondTransaction = Transaction.builder().date(Instant.now().minus(Period.ofDays(40))).price(new BigDecimal("65.55")).build();
		this.transactionService.addCustomerTransaction(firstTransaction, persistedCustomer.getId());
		this.transactionService.addCustomerTransaction(secondTransaction, persistedCustomer.getId());
		
		//when
		final BigInteger totalCustomerPoints = this.customerRewardService.getTotalCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(new BigInteger("20"), totalCustomerPoints);
	}
	
	@Test
	public void shouldReturnCorrectMonthlyCombinedPoints() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction firstTransaction = Transaction.builder().date(Instant.now()).price(new BigDecimal("155.55")).build();
		final Transaction secondTransaction = Transaction.builder().date(Instant.now().minus(Period.ofDays(40))).price(new BigDecimal("255.55")).build();
		this.transactionService.addCustomerTransaction(firstTransaction, persistedCustomer.getId());
		this.transactionService.addCustomerTransaction(secondTransaction, persistedCustomer.getId());
		
		//when
		final BigInteger lastMonthCustomerPoints = this.customerRewardService.getLastMonthCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(new BigInteger("160"), lastMonthCustomerPoints);
	}
	
	@Test
	public void shouldReturnCorrectTotalCombinedPoints() {
		//given
		final Customer customer = Customer.builder().firstName("William").lastName("Jones").build();
		final Customer persistedCustomer = this.customerService.addCustomer(customer);
		
		final Transaction firstTransaction = Transaction.builder().date(Instant.now()).price(new BigDecimal("155.55")).build();
		final Transaction secondTransaction = Transaction.builder().date(Instant.now().minus(Period.ofDays(40))).price(new BigDecimal("255.55")).build();
		this.transactionService.addCustomerTransaction(firstTransaction, persistedCustomer.getId());
		this.transactionService.addCustomerTransaction(secondTransaction, persistedCustomer.getId());
		
		//when
		final BigInteger totalCustomerPoints = this.customerRewardService.getTotalCustomerPoints(persistedCustomer.getId());
		
		//then
		assertEquals(new BigInteger("520"), totalCustomerPoints);
	}
}
