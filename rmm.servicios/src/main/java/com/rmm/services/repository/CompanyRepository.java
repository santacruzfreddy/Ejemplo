package com.rmm.services.repository;

import com.rmm.services.repository.crudRepository.CompanyCrudRepository;
import com.rmm.services.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository {
    private CompanyCrudRepository companyCrudRepository;

    public Company createCompany(Company company)
    {
        return  companyCrudRepository.save(company);
    }

}
