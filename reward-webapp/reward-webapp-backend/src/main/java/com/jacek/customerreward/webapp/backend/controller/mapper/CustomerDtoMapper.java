package com.jacek.customerreward.webapp.backend.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jacek.customerreward.webapp.backend.controller.dto.CustomerDto;
import com.jacek.customerreward.webapp.backend.model.Customer;

@Mapper(componentModel = "spring", uses = TransactionDtoMapper.class)
public interface CustomerDtoMapper {
	
	@Mappings({
			@Mapping(target = "transactions", ignore = true)
	})
	Customer map(final CustomerDto customerDto);
	
	List<CustomerDto> map(final List<Customer> customerList);
	
	CustomerDto map(final Customer customer);
}
