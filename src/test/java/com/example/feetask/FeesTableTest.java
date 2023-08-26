package com.example.feetask;

import com.example.feetask.exceptions.FeeAlreadyExistException;
import com.example.feetask.exceptions.UnvalidFeeException;
import com.example.feetask.pojo.Fee;
import com.example.feetask.pojo.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeesTableTest {

	private FeesTable feesTable;

	@Before
	public void setUp() {
		feesTable = new FeesTable();
	}


	@Test
	public void testAddNewFee() throws FeeAlreadyExistException, UnvalidFeeException {
		feesTable.addNewFee(new Fee("Finance", 6.0));

		assertEquals(Double.valueOf(6.0), feesTable.getFeeFromTable(new Transaction("Finance",6)));
	}

	@Test(expected = FeeAlreadyExistException.class)
	public void testAddNewFeeAlreadyExists() throws FeeAlreadyExistException, UnvalidFeeException {
		feesTable.addNewFee(new Fee("IT", 10.0));
	}

	@Test(expected = UnvalidFeeException.class)
	public void testAddNewFeeInvalidName() throws FeeAlreadyExistException, UnvalidFeeException {
		feesTable.addNewFee(new Fee("", 5.0));
	}

	@Test(expected = UnvalidFeeException.class)
	public void testAddNewFeeInvalidValue() throws FeeAlreadyExistException, UnvalidFeeException {
		feesTable.addNewFee(new Fee("HR", -2.0));
	}
}
