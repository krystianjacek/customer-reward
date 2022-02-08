package com.jacek.customerreward.webapp.backend.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacek.customerreward.webapp.backend.dao.mapper.CustomerMapper;
import com.jacek.customerreward.webapp.backend.dao.repository.CustomerRepository;
import com.jacek.customerreward.webapp.backend.model.Customer;
import com.jacek.customerreward.webapp.backend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private final CustomerRepository customerRepository;
	
	private final CustomerMapper customerMapper;
	
	public CustomerServiceImpl(final CustomerRepository customerRepository,
							   final CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
	
	@Override
	@Transactional
	public void addCustomer(final Customer customer) {
		this.customerRepository.save(this.customerMapper.map(customer));
	}
	
	@Override
	public List<Customer> getCustomers() {
		return this.customerMapper.map(this.customerRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}
	
	@Override
	public Customer getCustomer(final long customerId) {
		//FIXME:
		return this.customerRepository.findById(customerId).map(this.customerMapper::map).orElseThrow(RuntimeException::new);
	}
	
	@Override
	public void updateCustomer(final Customer customer) {
	
	}
	
}
