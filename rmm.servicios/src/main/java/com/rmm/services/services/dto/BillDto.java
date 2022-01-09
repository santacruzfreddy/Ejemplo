package com.rmm.services.services.dto;

public class BillDto {
    Double costDevice = Double.valueOf(0L);
    Double costServiceWithOutType = Double.valueOf(0L);
    Double costDeviceMac = Double.valueOf(0L);
    Double costDeviceWindows = Double.valueOf(0L);
    Double total = Double.valueOf(0);

    public Double getCostDevice() {
        return costDevice;
    }

    public void setCostDevice(Double costDevice) {
        this.costDevice = costDevice;
    }

    public Double getCostServiceWithOutType() {
        return costServiceWithOutType;
    }

    public void setCostServiceWithOutType(Double costServiceWithOutType) {
        this.costServiceWithOutType = costServiceWithOutType;
    }

    public Double getCostDeviceMac() {
        return costDeviceMac;
    }

    public void setCostDeviceMac(Double costDeviceMac) {
        this.costDeviceMac = costDeviceMac;
    }

    public Double getCostDeviceWindows() {
        return costDeviceWindows;
    }

    public void setCostDeviceWindows(Double costDeviceWindows) {
        this.costDeviceWindows = costDeviceWindows;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
