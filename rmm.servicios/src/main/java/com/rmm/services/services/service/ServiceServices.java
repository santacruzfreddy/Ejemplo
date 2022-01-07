package com.rmm.services.services.service;

import com.rmm.services.entity.ServiceEntity;

import java.util.List;

public interface ServiceServices {

    public ServiceEntity createService(ServiceEntity service);

    public ServiceEntity updateService(ServiceEntity service);

    public ServiceEntity getService(Long serviceId);

    public List<ServiceEntity> getAllService();
}
