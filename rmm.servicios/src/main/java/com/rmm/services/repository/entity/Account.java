package com.rmm.services.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long accountId;

    @Column(name = "account_name")
    String accountName;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    Customer customer;

    //List<Device> listDevices;

    /**
     * This field is used for logic delete
     */
    @Column
    Boolean state;

    /*
    auditory fields
    */
    @Column(name = "creation_date")
    LocalDateTime creationDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;
}
