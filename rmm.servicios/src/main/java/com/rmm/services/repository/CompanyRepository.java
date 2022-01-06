package com.rmm.services.repository;

import com.rmm.services.repository.crud.CompanyCrudRepository;
import com.rmm.services.repository.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository {
    private CompanyCrudRepository companyCrudRepository;

    public Company createCompany(Company company)
    {
        return  companyCrudRepository.save(company);
    }

}
