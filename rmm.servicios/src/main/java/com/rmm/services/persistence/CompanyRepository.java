package com.rmm.services.persistence;

import com.rmm.services.persistence.crud.CompanyCrudRepository;
import com.rmm.services.persistence.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository {
    private CompanyCrudRepository companyCrudRepository;

    public Company createCompany(Company company)
    {
        return  companyCrudRepository.save(company);
    }

}
