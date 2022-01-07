package com.rmm.services.services.serviceImpl;

import com.rmm.services.repository.ServiceRepository;
import com.rmm.services.services.service.ServiceServices;
import org.springframework.stereotype.Service;
import com.rmm.services.entity.ServiceEntity;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceServices {

    private ServiceRepository serviceRepository;

    @Override
    public ServiceEntity createService(ServiceEntity service) {
        return null;
    }

    @Override
    public ServiceEntity updateService(ServiceEntity service) {
        return null;
    }

    @Override
    public ServiceEntity getService(Long serviceId) {
        return null;
    }

    @Override
    public List<ServiceEntity> getAllService() {
        return null;
    }
}
