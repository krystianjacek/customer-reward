package com.jacek.customerreward.webapp.backend.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	List<Transaction> transactions;
	
	public void addTransaction(final Transaction transaction) {
		this.transactions.add(transaction);
	}
}
