package com.rmm.services.repository;

import com.rmm.services.repository.crudRepository.CompanyCrudRepository;
import com.rmm.services.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepository {
    @Autowired
    private CompanyCrudRepository companyCrudRepository;

    public Company createCompany(Company company)
    {
        return  companyCrudRepository.save(company);
    }

    public Company updateCompany(Company company)
    {
        return  companyCrudRepository.save(company);
    }

    public Optional<Company> getCompany(Long companyId)
    {
        return  companyCrudRepository.findByCompanyId(companyId);
    }

}
