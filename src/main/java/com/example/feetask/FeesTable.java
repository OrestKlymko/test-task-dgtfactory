package com.example.feetask;


import com.example.feetask.exceptions.FeeAlreadyExistException;
import com.example.feetask.exceptions.UnvalidFeeException;
import com.example.feetask.pojo.Fee;
import com.example.feetask.pojo.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FeesTable {

	private static final List<Fee> feesList = new ArrayList<>();

	static {
		feesList.add(new Fee("IT", 8.0));
		feesList.add(new Fee("Marketing", 4.0));
	}

	public static Double getFeeFromTable(Transaction transaction) {
		Optional<Fee> first = feesList.stream()
				.filter(fee -> fee.getName().equals(transaction.getTransactionType()))
				.findFirst();
		return first.map(Fee::getValue).orElse(1.0);
	}

	public void addNewFee(Fee newFee) throws FeeAlreadyExistException, UnvalidFeeException {
		Optional<Fee> first = feesList.stream()
				.filter(fee -> fee.getName().equals(newFee.getName()))
				.findAny();

		if (first.isPresent()) {
			throw new FeeAlreadyExistException(
					String.format("%s already exist with value %s", first.get().getName(), first.get().getValue())
			);
		}

		if (!newFee.getName().isEmpty() && newFee.getValue() > 0) {
			feesList.add(newFee);
		} else throw new UnvalidFeeException("Name of fee can't be empty and value should be a positive number");
	}
}
