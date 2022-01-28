package com.jacek.customerreward.webapp.backend.service;

import java.math.BigInteger;

import com.jacek.customerreward.webapp.backend.model.Transaction;

public class RewardPointsCalculator {
	
	private static final BigInteger SECOND_THRESHOLD = new BigInteger("100");
	
	private static final BigInteger SECOND_THRESHOLD_POINTS = new BigInteger("2");
	
	private static final BigInteger FIRST_THRESHOLD = new BigInteger("50");
	
	private static final BigInteger FIRST_THRESHOLD_POINTS = new BigInteger("1");
	
	public static BigInteger calculatePoints(final Transaction transaction) {
		final BigInteger transactionPriceInt = transaction.getPrice().toBigInteger();
		if (transactionPriceInt.compareTo(SECOND_THRESHOLD) > 0) {
			BigInteger points = transactionPriceInt.subtract(SECOND_THRESHOLD);
			points = points.multiply(SECOND_THRESHOLD_POINTS);
			return points.add(FIRST_THRESHOLD.multiply(FIRST_THRESHOLD_POINTS));
		}
		else if (transactionPriceInt.compareTo(FIRST_THRESHOLD) > 0) {
			final BigInteger points = transactionPriceInt.subtract(FIRST_THRESHOLD);
			return points.multiply(FIRST_THRESHOLD_POINTS);
		}
		else {
			return BigInteger.ZERO;
		}
	}
}
