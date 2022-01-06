package com.rmm.services.repository.crud;

import com.rmm.services.repository.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
}
