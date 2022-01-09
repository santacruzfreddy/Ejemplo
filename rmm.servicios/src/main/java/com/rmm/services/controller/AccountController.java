package com.rmm.services.controller;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.Device;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.services.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @Autowired
    AccountServices accountService;
    @GetMapping("/get/{accountId}")
    public Account getAccount(@PathVariable("accountId") Long accountId) throws NoSuchMethodException {
        return accountService.getAccount(accountId);
    }

    @PostMapping("/addService")
    public ResponseEntity<String> addService(@RequestBody AccountsServicePK accountsServicePK) throws NoSuchMethodException {
        return accountService.addService(accountsServicePK) ;
    }

    @PostMapping("/deleteService")
    public ResponseEntity<String> deleteService(@RequestBody AccountsServicePK accountsServicePK) throws NoSuchMethodException {
        return accountService.deleteService(accountsServicePK);
    }

    @PostMapping("/addDevice/{accountId}")
    public ResponseEntity<String> addDevice(@PathVariable("accountId") Long accountId, @RequestBody Device device) throws NoSuchMethodException {
        return accountService.addDevice(accountId,device);
    }

    @PutMapping("/updateDevice/{accountId}")
    public ResponseEntity<String> updateDevice(@PathVariable("accountId") Long accountId, @RequestBody Device device) throws NoSuchMethodException {
        return accountService.updateDevice(accountId,device);
    }

    @PostMapping("/deleteDevice/{accountId}/{deviceId}")
    public ResponseEntity<String> deleteDevice(@PathVariable("accountId") Long accountId,
                                               @PathVariable("deviceId") Long deviceId) throws NoSuchMethodException {
        return accountService.deleteDevice(accountId,deviceId);
    }

    @GetMapping("/calculateBill/{accountId}")
    public ResponseEntity<String> calculateBill(@PathVariable("accountId") Long accountId) throws NoSuchMethodException {
        return accountService.calculateBill(accountId);
    }
}
