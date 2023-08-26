package com.example.feetask.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
	private String transactionType;
	private double value;
}
