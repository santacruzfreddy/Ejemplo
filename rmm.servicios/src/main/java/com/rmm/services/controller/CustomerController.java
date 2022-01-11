package com.rmm.services.controller;

import com.rmm.services.entity.Customer;
import com.rmm.services.services.service.CustomerServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServices customerService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation("Create new customer also a new account")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/update")
    @ApiOperation("Update customer")
    @ResponseStatus(value = HttpStatus.OK)
    public Customer updateCustomer( @RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/get/{customerId}")
    @ApiOperation("Get customer by customerId")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Long customerId)
    {
        return customerService.getCustomer(customerId).map(customer ->
                        new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(
                        new ResponseEntity<>( HttpStatus.NOT_FOUND)
                );
    }

    @GetMapping("/getAll")
    @ApiOperation("Get all customers")
    public List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomer();
    }
}
