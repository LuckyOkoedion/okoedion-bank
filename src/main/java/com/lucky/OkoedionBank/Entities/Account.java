package com.lucky.OkoedionBank.Entities;

import com.lucky.OkoedionBank.Pojo.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String account_number;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    @Column
    private BigDecimal account_balance;
    @Column(nullable = false)
    private String account_name;
    @Column(nullable = false)
    private AccountType account_type;

    public Account() {
        this.account_balance = new BigDecimal("0");
    }

    public Account(String account_number, UserEntity user, BigDecimal account_balance,
                   String account_name, AccountType account_type) {
        super();
        this.account_balance = account_balance;
        this.account_name = account_name;
        this.account_number = account_number;
        this.account_type = account_type;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(BigDecimal account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getId().equals(account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
