package com.rmm.services.services.service;


import com.rmm.services.entity.Customer;

import java.util.List;

public interface CustomerServices {

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Customer getCustomer(Long customerId);

    public List<Customer> getAllCustomer();

}
