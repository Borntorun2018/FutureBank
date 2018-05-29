package com.smartbank.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartbank.persist.entity.transaction.Transaction;
import com.smartbank.persist.repo.transaction.TransactionRepository;
import com.smartbank.service.transaction.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	@Autowired TransactionRepository transactionRepo;
	
	@Override
	public List<Transaction> getAllTransactionsForAccount(Long accountId) {
		return transactionRepo.findAllByAccount(accountId);
	}

}
