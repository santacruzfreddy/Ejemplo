package com.rmm.services.repository;

import com.rmm.services.repository.crudRepository.AccountCrudRepository;
import com.rmm.services.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepository {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    public Account createAccount(Account account)
    {
        return accountCrudRepository.save(account);
    }

    public Account updateAccount(Account account)
    {
        return accountCrudRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountId) throws NoSuchMethodException {
            return this.accountCrudRepository.findByAccountId(accountId);
    }
}
