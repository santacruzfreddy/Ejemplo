package com.rmm.services.repository.crud;

import com.rmm.services.repository.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {

    Account findByAccountIdOrderByAccountNameAsc(Long accountId);
}
