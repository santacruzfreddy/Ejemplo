package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
}
