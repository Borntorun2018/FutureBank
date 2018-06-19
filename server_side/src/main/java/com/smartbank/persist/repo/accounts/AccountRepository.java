package com.smartbank.persist.repo.accounts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smartbank.persist.entity.accounts.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
