package com.example.feetask.service;

import com.example.feetask.FeesTable;
import com.example.feetask.pojo.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeServiceTest {

	@Test
	void calculateFinalValueSuccessTest() {
		Transaction transaction = new Transaction("IT",10.0);
		Double feeFromTable = FeesTable.getFeeFromTable(transaction);
		double expectedValue = feeFromTable * transaction.getValue();
		assertEquals(expectedValue,80);
	}
}