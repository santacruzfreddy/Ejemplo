package com.rmm.services.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rmm.services.enumeration.TypeDevice;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    Long deviceId;

    @Column(name = "device_name")
    String deviceName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Enumerated(EnumType.STRING)
    private TypeDevice type;

    /**
     * This field is used for logic delete
     */
    Boolean state;

    /*
    auditory fields
    */
    @Column(name = "creation_date")
    LocalDateTime creationDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    public Device() {
    }

    public Device(Long deviceId, String deviceName, Account account, TypeDevice type, Boolean state) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.account = account;
        this.type = type;
        this.state = state;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public TypeDevice getType() {
        return type;
    }

    public void setType(TypeDevice type) {
        this.type = type;
    }
}
