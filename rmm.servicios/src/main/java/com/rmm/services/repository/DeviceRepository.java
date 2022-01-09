package com.rmm.services.repository;

import com.rmm.services.entity.AccountsServicePK;
import com.rmm.services.entity.Device;
import com.rmm.services.entity.ServiceEntity;
import com.rmm.services.repository.crudRepository.DeviceCrudRepository;
import com.rmm.services.repository.crudRepository.ServiceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DeviceRepository {
    @Autowired
    private DeviceCrudRepository deviceCrudRepository;

    public Device createDevice(Device device)
    {
        return deviceCrudRepository.save(device);
    }

    public Device updateDevice(Device device)
    {
        return deviceCrudRepository.save(device);
    }

    public Optional<Device> getDeviceById(Long deviceId)
    {
        return deviceCrudRepository.findByDeviceId(deviceId);
    }

    public Boolean deleteDevice(Long deviceId)
    {
        return getDeviceById(deviceId).map(device -> {
            deviceCrudRepository.delete(device);
            return true;
        }).orElse(false);
    }
}
