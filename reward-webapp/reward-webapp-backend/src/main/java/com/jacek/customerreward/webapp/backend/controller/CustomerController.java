package com.jacek.customerreward.webapp.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.controller.dto.TransactionDto;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.CustomerService;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@RestController
@RequestMapping("/api/internal/transaction")
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService transactionService;
	
	public TransactionController(final CustomerService customerService,
									final TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE
	)
	@ResponseBody
	public void createTransaction(@RequestBody final TransactionDto transaction) {
		this.transactionService.createCustomerTransaction(new Transaction(), 1l);
	}
}
