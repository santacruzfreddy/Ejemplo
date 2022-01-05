package com.rmm.services.persistence.crud;

import com.rmm.services.persistence.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCrudRepository extends CrudRepository<Device, Long> {
}
