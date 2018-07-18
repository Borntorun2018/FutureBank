package com.eBusiness.persist.repo.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eBusiness.persist.entity.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List<Transaction> findAllByAccount(Long account);
}
