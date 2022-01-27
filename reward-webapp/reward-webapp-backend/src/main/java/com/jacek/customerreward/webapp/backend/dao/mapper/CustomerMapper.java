package com.jacek.customerreward.webapp.backend.dao.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jacek.customerreward.webapp.backend.dao.entity.TransactionEntity;
import com.jacek.customerreward.webapp.backend.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	
	@Mappings({
			@Mapping(target = "id", source = "id"),
			@Mapping(target = "price", source = "price")
	})
	Transaction map(final TransactionEntity transaction);
	
	@Mappings({
			@Mapping(target = "id", source = "id"),
			@Mapping(target = "price", source = "price")
	})
	List<Transaction> map(final List<TransactionEntity> transaction);
}
