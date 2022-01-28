package com.jacek.customerreward.webapp.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.controller.dto.CustomerDto;
import com.jacek.customerreward.webapp.backend.controller.mapper.CustomerDtoMapper;
import com.jacek.customerreward.webapp.backend.model.Transaction;
import com.jacek.customerreward.webapp.backend.service.CustomerService;

@RestController
@RequestMapping("/api/internal/customer")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	private final CustomerService customerService;
	
	private final CustomerDtoMapper customerDtoMapper;
	
	public CustomerController(final CustomerService customerService,
							  final CustomerDtoMapper customerDtoMapper) {
		this.customerService = customerService;
		this.customerDtoMapper = customerDtoMapper;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseBody
	public void addCustomer(@RequestBody final CustomerDto customerDto) {
		this.customerService.addCustomer(this.customerDtoMapper.map(customerDto));
	}
}
