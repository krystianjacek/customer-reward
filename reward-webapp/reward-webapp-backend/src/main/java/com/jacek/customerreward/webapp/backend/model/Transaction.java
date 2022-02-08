package com.jacek.customerreward.webapp.backend.model;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private long id;
	
	private BigDecimal price;
	
	private Instant date;
}
