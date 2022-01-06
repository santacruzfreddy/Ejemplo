package com.rmm.services.repository.crud;

import com.rmm.services.repository.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCrudRepository extends CrudRepository<Device, Long> {
}
