package com.rmm.services.services.service;

import com.rmm.services.entity.ServiceEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceServices {

    public ServiceEntity createService(ServiceEntity service);

    public ServiceEntity updateService(ServiceEntity service);

    public Optional<ServiceEntity> getService(Long serviceId);

    public List<ServiceEntity> getAllService();

    public ResponseEntity<String> createMultipleServices(List<ServiceEntity> services);
}
