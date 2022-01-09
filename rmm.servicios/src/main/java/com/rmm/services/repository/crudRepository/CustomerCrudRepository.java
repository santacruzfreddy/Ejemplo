package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByCustomerId(Long customerId);

}
