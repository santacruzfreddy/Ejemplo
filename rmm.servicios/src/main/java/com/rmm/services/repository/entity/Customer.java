package com.rmm.services.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Long customerId;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "user_name")
    String userName;

    @Column(name = "user_password")
    String userPassword;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    Account account;

    /*
    auditory fields
    * */
    @Column(name = "creation_date")
    LocalDateTime creationDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

}
