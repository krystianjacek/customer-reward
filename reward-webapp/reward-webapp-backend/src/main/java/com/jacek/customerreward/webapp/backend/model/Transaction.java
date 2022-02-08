package com.jacek.customerreward.webapp.backend.model;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
	private long id;
	
	private BigDecimal price;
	
	private Instant date;
	
	//lombok has some issue with builder visibility
	public static Transaction.TransactionBuilder builder() {
		return new Transaction.TransactionBuilder();
	}
}
