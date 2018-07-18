package com.eBusiness.service.transaction;

import java.util.List;

import com.eBusiness.persist.entity.transaction.Transaction;

public interface TransactionService {

	public List<Transaction> getAllTransactionsForAccount(Long accountId);
	
}
