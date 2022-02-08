package com.jacek.customerreward.webapp.backend.controller;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.controller.dto.CustomerPointsDto;
import com.jacek.customerreward.webapp.backend.service.CustomerRewardService;

@RestController
@RequestMapping("/api/internal/reward")
public class CustomerRewardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRewardController.class);
	
	private final CustomerRewardService customerRewardService;
	
	public CustomerRewardController(final CustomerRewardService customerRewardService) {
		this.customerRewardService = customerRewardService;
	}
	
	@GetMapping("/customerId/{customerId}/month")
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<CustomerPointsDto> getLastMonthCustomerPoints(@PathVariable final long customerId) {
		LOGGER.debug("Get last month points for customer id {}", customerId);
		final BigInteger monthlyScore = this.customerRewardService.getLastMonthCustomerPoints(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(new CustomerPointsDto(customerId, monthlyScore));
	}
	
	@GetMapping("/customerId/{customerId}/total")
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<CustomerPointsDto> getTotalCustomerPoints(@PathVariable final long customerId) {
		LOGGER.debug("Get total points for customer id {}", customerId);
		final BigInteger totalScore = this.customerRewardService.getTotalCustomerPoints(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(new CustomerPointsDto(customerId, totalScore));
	}
}
