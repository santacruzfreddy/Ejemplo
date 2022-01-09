package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyCrudRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByCompanyId(Long companyId);
}
