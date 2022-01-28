package com.jacek.customerreward.webapp.backend.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jacek.customerreward.webapp.backend.dao.entity.CustomerEntity;
import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;
import com.jacek.customerreward.webapp.backend.model.Customer;
import com.jacek.customerreward.webapp.backend.model.Transaction;

@Mapper(componentModel = "spring", uses = TransactionMapper.class)
public interface CustomerMapper {
	
	@Mappings({
			@Mapping(target = "userName", source = "userName")
	})
	CustomerEntity map(final Customer customer);
	
	@Mappings({
			@Mapping(target = "userName", source = "userName"),
			@Mapping(target = "transactions", source = "transactionEntities")
	})
	Customer map(final CustomerEntity customer);
}
