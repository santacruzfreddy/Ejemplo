package com.rmm.services.controller;

import com.rmm.services.entity.Customer;
import com.rmm.services.services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/update")
    public Customer updateCustomer( @RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/get/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long customerId)
    {
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomer();
    }
}
