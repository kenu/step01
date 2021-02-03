package com.okmall.spring.controller;

import com.okmall.spring.component.validation.RepeatedField;
import com.okmall.spring.domain.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RepeatedField(field = "password")
@Getter
@Setter
@ToString
public class AccountForm {
    @NotNull(groups = Create.class)
    @Size(max = 40)
    private String username;

    @NotNull(groups = Create.class)
    @Size(min = 8)
    private String password;

    private String repeatedPassword;

    @NotNull
    @Email
    private String email;

    Account toAccount() {
        Account account = new Account();
        BeanUtils.copyProperties(this, account);
        return account;
    }

    interface Create {}
}
