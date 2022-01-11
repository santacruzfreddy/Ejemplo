package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByAccountId(Long accountId);

    Optional<List<Account>> findByState(boolean state);
}
