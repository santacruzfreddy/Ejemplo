package com.rmm.services.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Long accountId;
    String accountName;
    Boolean state;
}
