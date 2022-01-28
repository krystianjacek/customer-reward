package com.jacek.customerreward.webapp.backend.controller.mapper;

import org.mapstruct.Mapper;

import com.jacek.customerreward.webapp.backend.controller.dto.TransactionDto;
import com.jacek.customerreward.webapp.backend.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionDtoMapper {
	Transaction map(final TransactionDto transactionDto);
}
