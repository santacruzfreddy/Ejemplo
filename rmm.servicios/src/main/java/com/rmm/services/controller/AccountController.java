package com.rmm.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @GetMapping("/getAccount/{accountId}")
    public String getAccount(@PathVariable("accountId") Long accountId)
    {
        return "Get Account successful.";
    }
}
