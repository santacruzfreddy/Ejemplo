package com.rmm.services.services.service;


import com.rmm.services.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServices {

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Optional<Customer> getCustomer(Long customerId);

    public List<Customer> getAllCustomer();

}
