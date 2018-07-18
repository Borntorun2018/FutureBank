package com.eBusiness.persist.repo.accounts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eBusiness.persist.entity.accounts.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
