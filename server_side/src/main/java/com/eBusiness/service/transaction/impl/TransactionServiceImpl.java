package com.eBusiness.service.transaction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eBusiness.persist.entity.transaction.Transaction;
import com.eBusiness.persist.repo.transaction.TransactionRepository;
import com.eBusiness.service.transaction.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	@Autowired TransactionRepository transactionRepo;
	
	@Override
	public List<Transaction> getAllTransactionsForAccount(Long accountId) {
		return transactionRepo.findAllByAccount(accountId);
	}

}
