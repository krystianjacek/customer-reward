package com.jacek.customerreward.webapp.backend.service;

import java.util.List;

import com.jacek.customerreward.webapp.backend.model.Customer;

public interface CustomerService {
	
	void addCustomer(final Customer customer);
	
	List<Customer> getCustomers();
	
	Customer getCustomer(final long customerId);
}
