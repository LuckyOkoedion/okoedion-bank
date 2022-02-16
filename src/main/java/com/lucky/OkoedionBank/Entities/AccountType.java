package com.lucky.OkoedionBank.Entities;

import com.lucky.OkoedionBank.Pojo.AccountTypeEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountType <T extends AccountTypeEnum> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    final T theType;

    public AccountType(T type) {
        this.theType = type;

    }

    public T getTheType() {
        return theType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
