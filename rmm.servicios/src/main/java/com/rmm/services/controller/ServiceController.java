package com.rmm.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController
{
    @GetMapping("/getService/{serviceId}")
    public String getService(@PathVariable("serviceId") Long serviceId)
    {
        return "Get Service successful.";
    }
}
