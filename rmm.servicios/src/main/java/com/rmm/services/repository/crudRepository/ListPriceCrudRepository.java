package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.ListPrice;
import com.rmm.services.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ListPriceCrudRepository extends CrudRepository<ListPrice, Long> {

    Optional<ListPrice> findByListPriceId(Long ListPriceId);
}
