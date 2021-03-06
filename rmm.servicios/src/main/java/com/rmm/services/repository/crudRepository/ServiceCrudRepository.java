package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ServiceCrudRepository extends CrudRepository<ServiceEntity, Long> {

    Optional<ServiceEntity> findByServiceId(Long serviceId);
}
