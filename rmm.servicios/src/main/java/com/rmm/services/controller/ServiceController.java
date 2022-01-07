package com.rmm.services.controller;

import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.services.service.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController
{
    @Autowired
    private ServiceServices serviceServices;

    @PostMapping("/create")
    public ServiceEntity createService(@RequestBody ServiceEntity service)
    {
        return serviceServices.createService(service);
    }

    @PostMapping("/update")
    public ServiceEntity updateService(@RequestBody ServiceEntity service)
    {
        return serviceServices.updateService(service);
    }

    @GetMapping("/get/{serviceId}")
    public ServiceEntity getService(@PathVariable("serviceId") Long serviceId)
    {
        return serviceServices.getService(serviceId);
    }

}
