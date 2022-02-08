package com.jacek.customerreward.webapp.backend.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
	
	List<Transaction> transactions;
	private Long id;
	private String firstName;
	private String lastName;
	
	//lombok has some issue with builder visibility
	public static CustomerBuilder builder() {
		return new CustomerBuilder();
	}
}
