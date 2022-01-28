package com.jacek.customerreward.webapp.backend.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jacek.customerreward.webapp.backend.controller.dto.CustomerDto;
import com.jacek.customerreward.webapp.backend.controller.dto.TransactionDto;
import com.jacek.customerreward.webapp.backend.model.Customer;
import com.jacek.customerreward.webapp.backend.model.Transaction;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
	Customer map(final CustomerDto customerDto);
	
	CustomerDto map(final Customer customer);
	
	List<CustomerDto> map(final List<Customer> customer);
}
