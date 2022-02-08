package com.jacek.customerreward.webapp.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacek.customerreward.webapp.backend.controller.dto.CustomerDto;
import com.jacek.customerreward.webapp.backend.controller.mapper.CustomerDtoMapper;
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
	
	@GetMapping(
			path = "/{customerId}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseBody
	public CustomerDto getCustomer(@PathVariable final long customerId) {
		return this.customerDtoMapper.map(this.customerService.getCustomer(customerId));
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseBody
	public List<CustomerDto> getCustomers() {
		return this.customerDtoMapper.map(this.customerService.getCustomers());
	}
}
