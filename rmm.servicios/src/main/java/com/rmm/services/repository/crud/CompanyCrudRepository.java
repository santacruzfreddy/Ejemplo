package com.rmm.services.repository.crud;

import com.rmm.services.repository.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyCrudRepository extends CrudRepository<Company, Long> {
}
