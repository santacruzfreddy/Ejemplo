package com.rmm.services.services.serviceImpl;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsService;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.AccountRepository;
import com.rmm.services.repository.AccountsServiceRepository;
import com.rmm.services.repository.ServiceRepository;
import com.rmm.services.services.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountServices {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AccountsServiceRepository accountsServiceRepository;

    @Override
    public Account getAccount(Long accountId) {
        return accountRepository.getAccountById(accountId).get();
    }

    @Override
    public Account addService(AccountsServicePK accountsServicePK) {
        try {
            Account account = accountRepository.getAccountById(accountsServicePK.getAccountId()).get();
            if (account == null) {
                return null;
            }

            ServiceEntity service = serviceRepository.getServiceById(accountsServicePK.getServiceId());
            if (service == null) {
                return null;
            }

            //account.getService().stream().map(accountsService -> )

            AccountsService services = new AccountsService();
            services.setAccountServiceId(accountsServicePK);
            accountsServiceRepository.createAccountsService(services);
            return account;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Account deleteService(AccountsServicePK accountsServicePK) {
        return null;
    }
}
