package com.smartbank.service.impl.accounts;


import org.springframework.beans.factory.annotation.Autowired;

import com.smartbank.persist.entity.accounts.Account;
import com.smartbank.persist.repo.accounts.AccountRepository;
import com.smartbank.service.accounts.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired public AccountRepository accountRepo;
	
	public Account getAccountById(Long id) {
		if(null==id){
			throw new IllegalArgumentException("No id parameter!");
		}
		return accountRepo.getOne(id);
	}

}
