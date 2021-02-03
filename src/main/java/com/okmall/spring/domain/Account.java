package com.okmall.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {
    private String username;
    private String password;
    private String email;
}
