package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCrudRepository extends CrudRepository<Device, Long> {
}
