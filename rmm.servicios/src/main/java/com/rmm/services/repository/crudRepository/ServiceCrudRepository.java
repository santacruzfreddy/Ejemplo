package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCrudRepository extends CrudRepository<ServiceEntity, Long> {
}
