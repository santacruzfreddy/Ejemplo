package com.rmm.services.persistence.crud;

import com.rmm.services.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {
}
