package com.jacek.customerreward.webapp.backend.service;

import java.math.BigInteger;

public interface CustomerRewardService {
	
	BigInteger getLastMonthCustomerPoints(final long customerId);
	
	BigInteger getTotalCustomerPoints(final long customerId);
}
