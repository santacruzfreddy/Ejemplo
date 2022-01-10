package com.rmm.services.services.serviceImpl;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.AccountsService;
import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.AccountRepository;
import com.rmm.services.repository.AccountsServiceRepository;
import com.rmm.services.repository.ServiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

public class AccountServiceImplTest {

    @Mock
    AccountRepository accountRepository;

    @Mock
    ServiceRepository serviceRepository;

    @Mock
    AccountsServiceRepository accountsServiceRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    ResponseEntity response;

    Optional<Account> account;
    Account accountAux;

    Optional<ServiceEntity> service;
    ServiceEntity serviceAux;

    Boolean delete;

    /*
    *  test service should exist
    *  test service not repeat
    *  test account should exist
    *  test add service successful
    *  test delete service successful
    *  test add service error
    *  before to add service should exist at least one device
    *
    * */

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        accountAux = new Account();
        accountAux.setService(new ArrayList<>());
        accountAux.setAccountId(3L);
        accountAux.setAccountName("Edison");
        account = Optional.of(accountAux);

        serviceAux = new ServiceEntity();
        serviceAux.setServiceId(1L);
        serviceAux.setServiceName("Antivirus");
        serviceAux.setApplyType(true);
        serviceAux.setPrices(new ArrayList<>());

        service = Optional.of(serviceAux);

        delete=true;
    }

    @DisplayName("This test, verify If account doesn't exist, then We Can add service to our account")
    @Test
    public void validate_NoExist_Account() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        response = new ResponseEntity<>("Account doesn't exist.",HttpStatus.NOT_FOUND);
        Assert.assertEquals(response, accountService.addService(new AccountsServicePK(2L,1L))
        );
    }

    @DisplayName("This test, verify If service doesn't exist, then We Can add service to our account")
    @Test
    public void validate_NoExist_Service() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        response = new ResponseEntity<>("Service doesn't exist.",HttpStatus.NOT_FOUND);
        Assert.assertEquals(response, accountService.addService(new AccountsServicePK(3L,2L))
        );
    }

    @DisplayName("This test, verify If service is add to our account")
    @Test
    public void validate_add_service() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        response = new ResponseEntity<>("Service add successful", HttpStatus.OK);
        Assert.assertEquals(response, accountService.addService(new AccountsServicePK(3L,1L))
        );
    }

    @DisplayName("This test, verify If service isn't add to our account")
    @Test
    public void validate_not_add_service() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        response = new ResponseEntity<>("Error can't add service.", HttpStatus.INTERNAL_SERVER_ERROR);
        Assert.assertEquals(response, accountService.addService(null));
    }

    @Test
    public void delete_service_successful() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        Mockito.when(accountsServiceRepository.deleteAccountsService(new AccountsServicePK(3L,1L))).thenReturn(delete);

        response = new ResponseEntity<>("Service delete successful", HttpStatus.OK);

        Assert.assertEquals(response, accountService.deleteService(new AccountsServicePK(3L,1L)));
    }

    @Test
    public void delete_service_error_when_null_parameter() throws NoSuchMethodException {
        Mockito.when(accountRepository.getAccountById(3L)).thenReturn(account);
        Mockito.when(serviceRepository.getServiceById(1L)).thenReturn(service);
        response =  new ResponseEntity<>("Exception null Point ", HttpStatus.INTERNAL_SERVER_ERROR);;
        Assert.assertEquals(response, accountService.deleteService(null));
    }
}