package com.smartbank.persist.repo.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartbank.persist.entity.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List<Transaction> findAllByAccount(Long account);
}
