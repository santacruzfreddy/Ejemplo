package com.rmm.services.services.serviceImpl;

import com.rmm.services.entity.*;
import com.rmm.services.enumeration.TypeDevice;
import com.rmm.services.repository.AccountRepository;
import com.rmm.services.repository.AccountsServiceRepository;
import com.rmm.services.repository.DeviceRepository;
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
import java.util.List;
import java.util.Optional;

public class AccountServiceImplTest {

    @Mock
    AccountRepository accountRepository;

    @Mock
    ServiceRepository serviceRepository;

    @Mock
    AccountsServiceRepository accountsServiceRepository;

    @Mock
    DeviceRepository deviceRepository;

    @InjectMocks
    AccountServiceImpl accountService;



    ResponseEntity response;

    Optional<Account> account;
    Account accountAux;

    Optional<ServiceEntity> service;
    ServiceEntity serviceAux;

    Boolean delete;

    List<Device> devices;
    List<AccountsService> services;

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

        delete = true;
        setterDataCalculateBill();
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

    /*
     * calculate cost all devices
     * calculate cost service without type (windows or mac)
     * calculate cost service with type windows
     * calculate cost service with type Mac
     */
    @Test
   public void calculateBill() throws NoSuchMethodException {

        Mockito.when(accountRepository.getAccountById(1L)).thenReturn(account);

        Assert.assertEquals(new ResponseEntity<>("Bill complete = " + 71.0, HttpStatus.OK),accountService.calculateBill(1L));
    }

    @Test
    public void calculateCostByDevices() {
        Assert.assertEquals(Optional.of(20.0).get(),accountService.calculateCostByDevices(devices.size()));
    }

    @Test
    public void calculateCostServiceWithOutType() {
        Assert.assertEquals(Optional.of(20.0).get(),accountService.calculateCostServiceWithOutType(services,devices));
    }

    @Test
    public void calculateCostServiceWithTypeDeviceWindows() {
        Assert.assertEquals(Optional.of(10.0).get(), accountService.calculateCostServiceWithTypeDeviceWindows(services, devices));
    }

    @Test
    public void calculateCostServiceWithTypeDeviceMac() {
        Assert.assertEquals(Optional.of(21.0).get(),accountService.calculateCostServiceWithTypeDeviceMac(services,devices));
    }

    public void setterDataCalculateBill()
    {
        devices = new ArrayList<>();
        services = new ArrayList<>();

        List<ListPrice> prices = new ArrayList<>();

        AccountsServicePK accountsServicePK1 = new AccountsServicePK(1L, 1L);
        AccountsServicePK accountsServicePK2 = new AccountsServicePK(1L, 2L);
        AccountsServicePK accountsServicePK3 = new AccountsServicePK(1L, 3L);

        prices.add(new ListPrice(1L, 5.0,TypeDevice.WindowsServer));
        prices.add(new ListPrice(2L, 5.0,TypeDevice.WindowsWorkstation));
        prices.add(new ListPrice(3L, 7.0,TypeDevice.Mac));

        ServiceEntity servicesAux1 = new ServiceEntity(1l,"Antivirus",true,true, prices);
        prices = new ArrayList<>();
        prices.add(new ListPrice(4L, 3.0,TypeDevice.WindowsServer));
        ServiceEntity servicesAux2 = new ServiceEntity(1l,"CloudBerry",false,true, prices);
        prices = new ArrayList<>();
        prices.add(new ListPrice(5L, 1.0,TypeDevice.WindowsServer));
        ServiceEntity servicesAux3 = new ServiceEntity(1l,"TeamViewer",false,true, prices);

        accountAux = new Account();

        devices.add(new Device(1L,"PC 1", accountAux, TypeDevice.WindowsServer,true));
        devices.add(new Device(2L,"PC 2", accountAux, TypeDevice.WindowsWorkstation,true));
        devices.add(new Device(3L,"PC 3", accountAux, TypeDevice.Mac,true));
        devices.add(new Device(4L,"PC 1", accountAux, TypeDevice.Mac,true));
        devices.add(new Device(5L,"PC 1", accountAux, TypeDevice.Mac,true));

        services.add(new AccountsService(accountsServicePK1, accountAux, servicesAux1));
        services.add(new AccountsService(accountsServicePK2, accountAux, servicesAux2));
        services.add(new AccountsService(accountsServicePK3, accountAux, servicesAux3));

        accountAux.setAccountId(1L);
        accountAux.setService(services);
        accountAux.setListDevices(devices);
        accountAux.setState(true);
        accountAux.setAccountName("Edison Mora Account");

        account = Optional.of(accountAux);
    }
}