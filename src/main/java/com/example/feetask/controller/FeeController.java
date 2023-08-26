package com.example.feetask.controller;


import com.example.feetask.pojo.Transaction;
import com.example.feetask.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fee")
public class FeeController {
	@Autowired
	private FeeService service;

	@GetMapping("/calculate")
	public ResponseEntity<Double> getTotalFee(@RequestBody Transaction transaction){
		double result = service.calculateFinalValue(transaction);
		return ResponseEntity.ok(result);
	}
}
