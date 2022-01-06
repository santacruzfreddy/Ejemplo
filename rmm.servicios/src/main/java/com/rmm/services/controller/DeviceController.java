package com.rmm.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController
{
    @GetMapping("/getDevice/{deviceId}")
    public String getDevice(@PathVariable("deviceId") Long deviceId)
    {
        return "Get Device successful.";
    }
}
