package com.rmm.services.persistence.crud;

import com.rmm.services.persistence.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyCrudRepository extends CrudRepository<Company, Long> {
}
