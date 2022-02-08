package com.jacek.customerreward.webapp.backend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.jacek.customerreward.webapp.backend.model.Customer;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.CustomerService;
import com.jacek.customerreward.webapp.backend.service.TransactionService;
import com.jacek.customerreward.webapp.backend.spring.CustomerRewardSpringConfig;

;

@SpringBootApplication
@Import(CustomerRewardSpringConfig.class)
public class CustomerRewardApplication {
	
	public static void main(final String[] args) {
		SpringApplication.run(CustomerRewardApplication.class, args);
	}
	
	public static Instant generateInstantBetween(final Instant startInclusive, final Instant endExclusive) {
		final long startSeconds = startInclusive.getEpochSecond();
		final long endSeconds = endExclusive.getEpochSecond();
		final long random = ThreadLocalRandom
				.current()
				.nextLong(startSeconds, endSeconds);
		
		return Instant.ofEpochSecond(random);
	}
	
	public static BigDecimal generateBigDecimalBetween(final BigDecimal min, final BigDecimal max) {
		final BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
		return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
	}
	
	@Bean
	public CommandLineRunner prepareData(final CustomerService customerService, final TransactionService transactionService) {
		return (args) -> {
			final List<Customer> customers = List.of(
					Customer.builder().firstName("James").lastName("Smith").build(),
					Customer.builder().firstName("John").lastName("Johnson").build(),
					Customer.builder().firstName("Robert").lastName("Williams").build(),
					Customer.builder().firstName("Michael").lastName("Brown").build(),
					Customer.builder().firstName("William").lastName("Jones").build()
			);
			
			final List<Long> customerIds = new ArrayList<>();
			for (final Customer c : customers) {
				customerIds.add(customerService.addCustomer(c).getId());
			}
			
			final Instant startInstant = Instant.now().minus(Period.ofDays(60));
			final Instant endInstant = Instant.now();
			final BigDecimal startPrice = new BigDecimal("0.01").setScale(2, RoundingMode.HALF_UP);
			final BigDecimal endPrice = new BigDecimal("2000.01").setScale(2, RoundingMode.HALF_UP);
			for (final Long customerId : customerIds) {
				final List<Transaction> transactions = List.of(
						Transaction.builder().date(generateInstantBetween(startInstant, endInstant)).price(generateBigDecimalBetween(startPrice, endPrice)).build(),
						Transaction.builder().date(generateInstantBetween(startInstant, endInstant)).price(generateBigDecimalBetween(startPrice, endPrice)).build(),
						Transaction.builder().date(generateInstantBetween(startInstant, endInstant)).price(generateBigDecimalBetween(startPrice, endPrice)).build(),
						Transaction.builder().date(generateInstantBetween(startInstant, endInstant)).price(generateBigDecimalBetween(startPrice, endPrice)).build(),
						Transaction.builder().date(generateInstantBetween(startInstant, endInstant)).price(generateBigDecimalBetween(startPrice, endPrice)).build()
				);
				for (final Transaction t : transactions) {
					transactionService.addCustomerTransaction(t, customerId);
				}
			}
		};
	}
}
