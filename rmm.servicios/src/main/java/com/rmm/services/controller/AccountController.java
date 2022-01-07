package com.rmm.services.controller;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.services.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @Autowired
    AccountServices accountService;
    @GetMapping("/get/{accountId}")
    public Account getAccount(@PathVariable("accountId") Long accountId)
    {
        return accountService.getAccount(accountId);
    }

    @PostMapping("/addService")
    public Account addService(@RequestBody AccountsServicePK accountsServicePK)
    {
        return accountService.addService(accountsServicePK);
    }

    @PostMapping("/deleteService")
    public Account deteleService(@RequestBody AccountsServicePK accountsServicePK)
    {
        return accountService.addService(accountsServicePK);
    }
}
