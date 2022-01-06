package com.rmm.services.repository.crud;

import com.rmm.services.repository.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {
}
