package com.smartbank.service.transaction;

import java.util.List;

import com.smartbank.persist.entity.transaction.Transaction;

public interface TransactionService {

	public List<Transaction> getAllTransactionsForAccount(Long accountId);
	
}
