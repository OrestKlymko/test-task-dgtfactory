package com.example.feetask;


import com.example.feetask.exceptions.FeeAlreadyExistException;
import com.example.feetask.exceptions.UnvalidFeeException;
import com.example.feetask.pojo.Transaction;

import java.util.HashMap;
import java.util.Map;


public class FeesTable {

	private static final Map<String, Double> feesTableMap = new HashMap<>();

	static {
		feesTableMap.put("IT", 8.0);
		feesTableMap.put("Marketing", 4.0);
	}

	public static Double getFeeFromTable(Transaction transaction) {
		for (Map.Entry<String, Double> fee : feesTableMap.entrySet()) {
			if (fee.getKey().equals(transaction.getTransactionType())) return fee.getValue();
		}
		return 1.0;
	}

	public void addNewFee(String name, Double value) throws FeeAlreadyExistException, UnvalidFeeException {
		if (feesTableMap.containsKey(name))
			throw new FeeAlreadyExistException(String.format("%s already exist with value %s", name, value));
		if (!name.isEmpty() && value > 0) {
			feesTableMap.put(name, value);
		} else throw new UnvalidFeeException("Name of fee can't be empty and value should be a positive number");
	}
}
