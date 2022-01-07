package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyCrudRepository extends CrudRepository<Company, Long> {
}
