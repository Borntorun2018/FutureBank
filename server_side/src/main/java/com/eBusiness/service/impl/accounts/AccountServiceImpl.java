package com.eBusiness.service.impl.accounts;


import org.springframework.beans.factory.annotation.Autowired;

import com.eBusiness.persist.entity.accounts.Account;
import com.eBusiness.persist.repo.accounts.AccountRepository;
import com.eBusiness.service.accounts.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired public AccountRepository accountRepo;
	
	public Account getAccountById(Long id) {
		if(null==id){
			throw new IllegalArgumentException("No id parameter!");
		}
		return accountRepo.getOne(id);
	}

}
