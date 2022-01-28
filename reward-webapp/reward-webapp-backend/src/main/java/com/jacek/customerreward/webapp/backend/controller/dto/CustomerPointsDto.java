package com.jacek.customerreward.webapp.backend.controller.dto;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerPointsDto {
	long customerId;
	
	BigInteger customerPoints;
}
