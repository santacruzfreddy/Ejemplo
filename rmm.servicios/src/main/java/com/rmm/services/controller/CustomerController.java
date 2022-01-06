package com.rmm.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @GetMapping("/getCustomer/{customerId}")
    public String getCustomer(@PathVariable("customerId") Long customerId)
    {
        return "Get Customer successful.";
    }
}
