package com.jacek.customerreward.webapp.backend.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jacek.customerreward.webapp.backend.controller.dto.TransactionDto;
import com.jacek.customerreward.webapp.backend.model.Transaction;

@Mapper(componentModel = "spring", uses = CustomerDtoMapper.class)
public interface TransactionDtoMapper {
	Transaction map(final TransactionDto transactionDto);
	
	TransactionDto map(final Transaction transaction);
	
	List<TransactionDto> map(final List<Transaction> transaction);
}
