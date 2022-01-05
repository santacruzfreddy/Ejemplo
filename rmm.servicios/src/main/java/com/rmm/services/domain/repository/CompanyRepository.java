package com.rmm.services.domain.repository;

import com.rmm.services.domain.Account;

import java.util.List;

public interface CompanyRepository {
    List<Account> getAll();

    Account save(Account account);

    void delete(Account account);
}
