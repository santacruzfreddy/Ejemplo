package com.rmm.services.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_services")
public class AccountService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
