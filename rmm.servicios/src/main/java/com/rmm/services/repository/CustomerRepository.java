package com.rmm.services.repository;

import com.rmm.services.entity.Customer;
import com.rmm.services.repository.crudRepository.AccountCrudRepository;
import com.rmm.services.entity.Account;
import com.rmm.services.repository.crudRepository.CustomerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    public Customer createCustomer(Customer customer)
    {
        return customerCrudRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer)
    {
        return customerCrudRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId)
    {
        return this.customerCrudRepository.findById(customerId).get();
    }

    public List<Customer> getAllCustomers()
    {
        return (List<Customer>) this.customerCrudRepository.findAll();
    }

}
