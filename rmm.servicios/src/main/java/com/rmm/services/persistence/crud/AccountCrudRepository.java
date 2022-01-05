package com.rmm.services.persistence.crud;

import com.rmm.services.persistence.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {

    Account findByAccountIdOrderByAccountNameAsc(Long accountId);
}
