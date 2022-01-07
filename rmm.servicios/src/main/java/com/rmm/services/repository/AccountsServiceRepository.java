package com.rmm.services.repository;

import com.rmm.services.entity.AccountsService;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.crudRepository.AccountsServiceCrudRepository;
import com.rmm.services.repository.crudRepository.ServiceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsServiceRepository {

    @Autowired
    private AccountsServiceCrudRepository accountsServiceCrudRepository;

    public AccountsService createAccountsService(AccountsService accountsService)
    {
        return accountsServiceCrudRepository.save(accountsService);
    }

    public AccountsService updateAccountsService(AccountsService accountsService)
    {
        return accountsServiceCrudRepository.save(accountsService);
    }
}
