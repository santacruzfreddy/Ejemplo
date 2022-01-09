package com.rmm.services.repository;

import com.rmm.services.entity.AccountsService;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.crudRepository.AccountsServiceCrudRepository;
import com.rmm.services.repository.crudRepository.ServiceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    public Optional<AccountsService> getAccountsService(AccountsServicePK accountsServiceId) {
        return accountsServiceCrudRepository.findByAccountServiceId(accountsServiceId);
    }

    public Boolean deleteAccountsService(AccountsServicePK accountsServiceId)
    {
        return getAccountsService(accountsServiceId).map(accountsService -> {
            accountsServiceCrudRepository.delete(accountsService);
            return true;
        }).orElse(false);
    }
}
