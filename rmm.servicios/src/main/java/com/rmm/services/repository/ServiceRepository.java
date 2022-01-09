package com.rmm.services.repository;

import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.crudRepository.ServiceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ServiceRepository {
    @Autowired
    private ServiceCrudRepository serviceCrudRepository;

    public ServiceEntity createService(ServiceEntity service)
    {
        return serviceCrudRepository.save(service);
    }

    public ServiceEntity updateService(ServiceEntity service)
    {
        return serviceCrudRepository.save(service);
    }

    public Optional<ServiceEntity> getServiceById(Long serviceId)
    {
        return serviceCrudRepository.findByServiceId(serviceId);
    }

}
