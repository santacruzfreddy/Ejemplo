package com.rmm.services.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts_services")
public class AccountsService {

    @EmbeddedId
    AccountsServicePK accountServiceId;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    ServiceEntity service;

    public AccountsServicePK getAccountServiceId() {
        return accountServiceId;
    }

    public void setAccountServiceId(AccountsServicePK accountServiceId) {
        this.accountServiceId = accountServiceId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }
}
