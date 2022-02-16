package com.lucky.OkoedionBank.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String phone_number;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    private List<Account> accounts = new ArrayList<>();

    public UserEntity() {

    }

    public UserEntity(String email, String first_name, String last_name,
                      String phone_number, String address, String password) {
        super();
        this.address = address;
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.password = password;
    }


    public void addAccounts(Account theAccount) {
        accounts.add(theAccount);
    }

    public void removeAccounts(Account theAccount) {
        accounts.remove(theAccount);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
