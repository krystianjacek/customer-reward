package com.jacek.customerreward.webapp.backend.controller.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.service.CustomerService;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@RestController
@RequestMapping("/api/internal/reward")
public class CustomerRewardController {
	
	private final CustomerService customerService;
	
	private final TransactionService transactionService;
	
	public CustomerRewardController(final CustomerService customerService,
									final TransactionService transactionService) {
		this.customerService = customerService;
		this.transactionService = transactionService;
	}
	
	@GetMapping("/{customerId}/month")
	ResponseEntity<CustomerPointsDTO> getMonthScore(@PathVariable final Long customerId) {
	
	}
	
	@GetMapping("/{customerId}/total")
	ResponseEntity<CustomerPointsDTO> getTotalScore(@PathVariable final Long customerId) {
	
	}
}
