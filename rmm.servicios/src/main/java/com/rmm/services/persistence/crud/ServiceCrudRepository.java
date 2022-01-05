package com.rmm.services.persistence.crud;

import com.rmm.services.persistence.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
}
