package com.jacek.customerreward.webapp.backend.dao.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jacek.customerreward.webapp.backend.dao.entity.CustomerEntity;
import com.jacek.customerreward.webapp.backend.model.Customer;

@Mapper(componentModel = "spring", uses = TransactionMapper.class)
public interface CustomerMapper {

	CustomerEntity map(final Customer customer);
	
	Customer map(final CustomerEntity customer);
	
	List<Customer> map(final List<CustomerEntity> customer);
}
