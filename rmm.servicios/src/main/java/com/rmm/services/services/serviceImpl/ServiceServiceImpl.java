package com.rmm.services.services.serviceImpl;

import com.rmm.services.repository.ServiceRepository;
import com.rmm.services.services.service.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rmm.services.entity.ServiceEntity;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceServices {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceEntity createService(ServiceEntity service) {
        return serviceRepository.createService(service);
    }

    @Override
    public ServiceEntity updateService(ServiceEntity service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public Optional<ServiceEntity> getService(Long serviceId) {
        return serviceRepository.getServiceById(serviceId);
    }

    @Override
    public List<ServiceEntity> getAllService() {
        return null;
    }
}
