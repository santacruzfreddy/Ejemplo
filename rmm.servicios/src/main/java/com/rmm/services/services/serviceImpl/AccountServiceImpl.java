package com.rmm.services.services.serviceImpl;

import com.rmm.services.entity.*;
import com.rmm.services.enumeration.TypeDevice;
import com.rmm.services.repository.AccountRepository;
import com.rmm.services.repository.AccountsServiceRepository;
import com.rmm.services.repository.DeviceRepository;
import com.rmm.services.repository.ServiceRepository;
import com.rmm.services.services.dto.BillDto;
import com.rmm.services.services.service.AccountServices;
import com.rmm.services.util.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountServices {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AccountsServiceRepository accountsServiceRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public AccountServiceImpl(AccountRepository accountRepository, ServiceRepository serviceRepository) {
        this.accountRepository = accountRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Account getAccount(Long accountId) throws NoSuchMethodException {
        return accountRepository.getAccountById(accountId).get();
    }

    @Override
    public ResponseEntity<String> addService(AccountsServicePK accountsServicePK) throws NoSuchMethodException {
    try{
        Optional<Account> account = accountRepository.getAccountById(accountsServicePK.getAccountId());;
        Optional<ServiceEntity> service = serviceRepository.getServiceById(accountsServicePK.getServiceId());;

        ValidationResponse response = validate(account ,service,true);

        if(!response.isSuccessful())
        {
            return new ResponseEntity<>(response.getInformation(), response.getHttpStatus());
        }
        List<AccountsService> list = account.get().getServices();

        AccountsService services = new AccountsService();
        services.setAccountServiceId(accountsServicePK);
        services.setAccount(account.get());
        services.setServices(service.get());

        list.add(services);
        account.get().setService(list);
        accountRepository.updateAccount(account.get());
        return new ResponseEntity<>("Service add successful", HttpStatus.OK);

    }
    catch(Exception e){
        return new ResponseEntity<>("Error can't add service.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @Override
    public ResponseEntity<String> deleteService(AccountsServicePK accountsServicePK) throws NoSuchMethodException {
    try {
        Optional<Account> account = accountRepository.getAccountById(accountsServicePK.getAccountId());;
        Optional<ServiceEntity> service = serviceRepository.getServiceById(accountsServicePK.getServiceId());;

        ValidationResponse response = validate(account ,service,false);

        if(!response.isSuccessful())
        {
            return new ResponseEntity<>(response.getInformation(), response.getHttpStatus());
        }

        Boolean result = accountsServiceRepository.deleteAccountsService(accountsServicePK);
        if(result) {
            return new ResponseEntity<>("Service delete successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Service can't delete.", HttpStatus.UNAUTHORIZED);
    }
    catch(Exception e){
        return new ResponseEntity<>("Exception null Point ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @Override
    public ResponseEntity<String> addDevice(Long accountId, Device device) throws NoSuchMethodException {
        Optional<Account> account = accountRepository.getAccountById(accountId);

        if(!account.isPresent())
        {
            return new ResponseEntity<>("Account doesn't exist.",HttpStatus.NOT_FOUND);
        }

        device.setAccount(account.get());
        account.get().getListDevices().add(device);
        accountRepository.updateAccount(account.get());
        return new ResponseEntity<>("Device add successful", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateDevice(Long accountId, Device device) throws NoSuchMethodException {
        Optional<Account> account = accountRepository.getAccountById(accountId);
        if(!account.isPresent())
        {
            return new ResponseEntity<>("Account doesn't exist.",HttpStatus.NOT_FOUND);
        }

        Optional<Device> deviceOptional = deviceRepository.getDeviceById(device.getDeviceId());
        if(!deviceOptional.isPresent())
        {
            return new ResponseEntity<>("Device doesn't exist.",HttpStatus.NOT_FOUND);
        }

        device.setAccount(account.get());
        deviceRepository.updateDevice(device);
        return new ResponseEntity<>("Device update successful", HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteDevice(Long accountId, Long deviceId) throws NoSuchMethodException {
        try{
        Optional<Account> account = accountRepository.getAccountById(accountId);
        if(!account.isPresent())
        {
            return new ResponseEntity<>("Account doesn't exist.",HttpStatus.NOT_FOUND);
        }

        Optional<Device> device = deviceRepository.getDeviceById(deviceId);
        if(!device.isPresent())
        {
            return new ResponseEntity<>("Device doesn't exist.",HttpStatus.NOT_FOUND);
        }

        account.get().getListDevices().remove(device.get());
        device.get().setAccount(null);
        accountRepository.updateAccount(account.get());
        if(deviceRepository.deleteDevice(deviceId)) {
            return new ResponseEntity<>("Device delete successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Device Not delete.", HttpStatus.UNAUTHORIZED);
    }
    catch(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    public ValidationResponse validate(Optional<Account> account, Optional<ServiceEntity> service, Boolean validate ) throws NoSuchMethodException{
        if (!account.isPresent()) {
            return new ValidationResponse(false,"Account doesn't exist.", HttpStatus.NOT_FOUND);
        }

        if (!service.isPresent()) {
            return new ValidationResponse(false,"Service doesn't exist.", HttpStatus.NOT_FOUND);
        }

        /*It only when is necessary
         * */
        if(validate)
        {
            for (AccountsService aService : account.get().getServices())
            {
                if((aService.getService().getServiceId().compareTo(service.get().getServiceId()) == 0))
                {
                    return new ValidationResponse(false,"Service assigned to Account.", HttpStatus.UNAUTHORIZED);
                }
            }
        }
        return new ValidationResponse(true);
    }

    @Override
    public ResponseEntity<String> calculateBill(Long accountId) throws NoSuchMethodException {

        BillDto bill= new BillDto();

        Optional<Account> account = accountRepository.getAccountById(accountId);
        if(!account.isPresent())
        {
            return new ResponseEntity<>("Account doesn't exist.",HttpStatus.NOT_FOUND);
        }

        List<Device> devices = account.get().getListDevices();
        if(devices.isEmpty())
        {
            return new ResponseEntity<>("Account doesn't have assigned devices.", HttpStatus.NOT_FOUND);
        }

        List<AccountsService> services = account.get().getServices();

        if(services.isEmpty())
        {
            return new ResponseEntity<>("Account doesn't have assigned service.", HttpStatus.NOT_FOUND);
        }

        bill.setCostDevice(calculateCostByDevices(devices.size()));

        bill.setCostServiceWithOutType(calculateCostServiceWithOutType(services, devices));

        bill.setCostDeviceMac(calculateCostServiceWithTypeDeviceMac(services,devices));

        bill.setCostDeviceWindows(calculateCostServiceWithTypeDeviceWindows(services, devices));

        bill.setTotal(bill.getCostDevice() + bill.getCostDeviceMac()
                + bill.getCostServiceWithOutType() + bill.getCostDeviceWindows());

        return new ResponseEntity<>("Bill complete = " + bill.getTotal(), HttpStatus.OK);
    }

    @Override
    public Optional<List<Account>> getAllAccount(boolean state) throws NoSuchMethodException {
        return accountRepository.getAllAccount(state);
    }

    public Double calculateCostByDevices(int numberDevices){

        return Double.valueOf(numberDevices * 4);
    }

    public Double calculateCostServiceWithOutType(List<AccountsService> services,List<Device> devices)
    {
        Double cost = 0.0;
        List<AccountsService> servicesWithOutType = services.stream().filter(
                acs -> !acs.getService().getApplyType()).collect(Collectors.toList());

        for(AccountsService service : servicesWithOutType)
        {
            cost += Double.valueOf(service.getService().getPrices().get(0).getPrice() * devices.size());
        }
        return cost;
    }

    public Double calculateCostServiceWithTypeDeviceWindows(List<AccountsService> services,List<Device> devices)
    {
        try {
            Double cost = 0.0;
            List<AccountsService> servicesWithType = services.stream().filter(
                    acs -> acs.getService().getApplyType()).collect(Collectors.toList());

            List<Device> deviceWindows = devices.stream().filter(
                            device -> (device.getType() == TypeDevice.WindowsServer ||
                                    device.getType() == TypeDevice.WindowsWorkstation))
                    .collect(Collectors.toList());

            for (AccountsService service : servicesWithType) {
                cost += Double.valueOf(deviceWindows.size() * service.getService().getPrices().stream().
                        filter(price -> (price.getType() == TypeDevice.WindowsWorkstation || price.getType() == TypeDevice.WindowsServer)).
                        collect(Collectors.toList()).get(0).getPrice());
            }
            return cost;
        }     catch (Exception e)
        {

            return 0.0;
        }
    }

    public Double calculateCostServiceWithTypeDeviceMac(List<AccountsService> services,List<Device> devices)
    {
        Double cost = 0.0;
        List<AccountsService> servicesWithType = services.stream().filter(
                acs -> acs.getService().getApplyType()).collect(Collectors.toList());

        List<Device> deviceMac = devices.stream().filter(device -> device.getType() == TypeDevice.Mac)
                .collect(Collectors.toList());

        for(AccountsService service : servicesWithType)
        {
            cost += Double.valueOf(deviceMac.size() * service.getService().getPrices().stream().
                    filter(price -> (price.getType() == TypeDevice.Mac)).
                    collect(Collectors.toList()).get(0).getPrice());
        }
        return cost;
    }
}
