package com.jacek.customerreward.webapp.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.controller.dto.TransactionDto;
import com.jacek.customerreward.webapp.backend.controller.mapper.TransactionDtoMapper;
import com.jacek.customerreward.webapp.backend.service.TransactionService;

@RestController
@RequestMapping("/api/internal/transaction")
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService transactionService;
	
	private final TransactionDtoMapper transactionDtoMapper;
	
	public TransactionController(final TransactionService transactionService,
								 final TransactionDtoMapper transactionDtoMapper) {
		this.transactionService = transactionService;
		this.transactionDtoMapper = transactionDtoMapper;
	}
	
	@PostMapping(
			path = "/customerId/{customerId}",
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.CREATED)
	public void addTransaction(@RequestBody final TransactionDto transactionDto, @PathVariable final long customerId) {
		this.transactionService.addCustomerTransaction(this.transactionDtoMapper.map(transactionDto), customerId);
	}
	
	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<TransactionDto> getAllTransactions() {
		return this.transactionDtoMapper.map(this.transactionService.getAllTransactions());
	}
}
