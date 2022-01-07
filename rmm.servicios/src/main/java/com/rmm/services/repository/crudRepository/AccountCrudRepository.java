package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {

    Account findByAccountIdOrderByAccountNameAsc(Long accountId);
}
