package com.rmm.services.repository.crudRepository;

import com.rmm.services.entity.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceCrudRepository extends CrudRepository<Device, Long> {
    Optional<Device> findByDeviceId(Long deviceId);
}
