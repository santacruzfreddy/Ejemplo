package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.AccountsService;
import com.rmm.services.entity.AccountsServicePK;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountsServiceCrudRepository extends CrudRepository<AccountsService, AccountsServicePK> {

    Optional<AccountsService> findByAccountServiceId(AccountsServicePK accountServiceId);

}
