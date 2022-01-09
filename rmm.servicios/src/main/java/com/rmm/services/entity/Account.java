package com.rmm.services.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long accountId;

    @Column(name = "account_name")
    private String accountName;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    Customer customer;

    @OneToMany(cascade = {CascadeType.ALL})
    List<Device> listDevices;

    @OneToMany(mappedBy = "account", cascade = {CascadeType.ALL})
    List<AccountsService> services;

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Device> getListDevices() {
        return listDevices;
    }

    public void setListDevices(List<Device> listDevices) {
        this.listDevices = listDevices;
    }

    public List<AccountsService> getServices() {
        return services;
    }

    public void setService(List<AccountsService> services) {
        this.services = services;
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
}
