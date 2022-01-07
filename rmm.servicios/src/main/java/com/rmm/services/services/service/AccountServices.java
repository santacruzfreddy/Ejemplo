package com.rmm.services.services.service;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsServicePK;

public interface AccountServices {

    public Account getAccount(Long accountId);

    public Account addService(AccountsServicePK accountsServicePK);

    public Account deleteService(AccountsServicePK accountsServicePK);

}
