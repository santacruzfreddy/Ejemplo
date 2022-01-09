package com.rmm.services.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    Long serviceId;

    @Column(name = "service_Name")
    String serviceName;

    @Column(name = "apply_type")
    Boolean applyType;

    /**
     * This field is used for logic delete
     */
    Boolean state;

    @OneToMany(cascade = {CascadeType.ALL})
    List<ListPrice> prices;

    /*
        auditory fields
        * */
    @Column(name = "creation_date")
    LocalDateTime creationDate;

    @Column(name = "creation_user")
    String creationUser;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    @Column(name = "update_user")
    String updateUser;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public List<ListPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ListPrice> prices) {
        this.prices = prices;
    }

    public Boolean getApplyType() {
        return applyType;
    }

    public void setApplyType(Boolean applyType) {
        this.applyType = applyType;
    }
}
