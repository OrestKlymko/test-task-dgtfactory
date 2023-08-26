package com.example.feetask.service;

import com.example.feetask.FeesTable;
import com.example.feetask.pojo.Transaction;
import org.springframework.stereotype.Service;


@Service
public class FeeService {
	public double calculateFinalValue(Transaction transaction){
		Double feeFromTable = FeesTable.getFeeFromTable(transaction);
		return feeFromTable*transaction.getValue();
	}

}
