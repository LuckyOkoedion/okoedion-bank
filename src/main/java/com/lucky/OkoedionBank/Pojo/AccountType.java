package com.lucky.OkoedionBank.Pojo;

public class AccountType <T extends AccountTypeEnum> {
    final T theType;

    public AccountType(T type) {
        this.theType = type;

    }
}
