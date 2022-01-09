package com.rmm.services.services.service;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.Device;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AccountServices {

    public Account getAccount(Long accountId) throws NoSuchMethodException;

    public ResponseEntity<String> addService(AccountsServicePK accountsServicePK) throws NoSuchMethodException;

    public ResponseEntity<String> deleteService(AccountsServicePK accountsServicePK) throws NoSuchMethodException;

    public ResponseEntity<String> addDevice(Long accountId, Device device) throws NoSuchMethodException;

    public ResponseEntity<String> updateDevice(Long accountId, Device device) throws NoSuchMethodException;

    public ResponseEntity<String> deleteDevice(Long accountId, Long deviceId) throws NoSuchMethodException;

    public ResponseEntity<String> calculateBill(Long accountId) throws NoSuchMethodException;

}
