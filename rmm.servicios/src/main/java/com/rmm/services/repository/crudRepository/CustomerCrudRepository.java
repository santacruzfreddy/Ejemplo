package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {


}
