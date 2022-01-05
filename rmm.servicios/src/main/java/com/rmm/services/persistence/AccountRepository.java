package com.rmm.services.persistence;

import com.rmm.services.persistence.crud.AccountCrudRepository;
import com.rmm.services.persistence.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepository {
    private AccountCrudRepository accountCrudRepository;

    public Account createAccount(Account account)
    {
        return accountCrudRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountId){
        return this.accountCrudRepository.findById(accountId);
    }

}
