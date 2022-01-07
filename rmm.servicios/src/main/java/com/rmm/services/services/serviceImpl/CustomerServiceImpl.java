package com.rmm.services.services.serviceImpl;

import com.rmm.services.entity.Account;
import com.rmm.services.entity.Customer;
import com.rmm.services.repository.CustomerRepository;
import com.rmm.services.services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        //Setter all account fields before save customer
        Account account = new Account();
        account.setAccountName(customer.getCustomerName() + " " + LocalDateTime.now());
        account.setCreationDate(LocalDateTime.now());
        account.setState(true);
        customer.setAccount(account);
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }
}
