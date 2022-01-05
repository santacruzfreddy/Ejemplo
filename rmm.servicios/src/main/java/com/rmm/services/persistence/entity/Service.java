package com.rmm.services.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    Long serviceId;

    @Column(name = "service_Name")
    String serviceName;

    /**
     * This field is used for logic delete
     */
    Boolean state;

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
}
