package com.lucky.OkoedionBank.Pojo;

import com.lucky.OkoedionBank.Entities.Account;
import com.lucky.OkoedionBank.Entities.CreditTransactions;
import com.lucky.OkoedionBank.Entities.DebitTransactions;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String address;
    private List<Account> accounts = new ArrayList<>();
    private List<CreditTransactions> credit_transactions = new ArrayList<>();
    private List<DebitTransactions> debit_transactions = new ArrayList<>();

    public UserDto() {

    }

    public UserDto(String email, String first_name, String last_name,
                String phone_number, String address,
                List<Account> accounts, List<CreditTransactions> credit_transactions,
                List<DebitTransactions> debit_transactions) {
        super();
        this.accounts = accounts;
        this.address = address;
        this.credit_transactions = credit_transactions;
        this.debit_transactions = debit_transactions;
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }


    public void addAccount(Account theAccount) {

    }

    public void removeAccount(Account theAccount) {

    }

    public void addCreditTransaction(CreditTransactions theCreditTrans) {

    }

    public void removeCreditTransaction(CreditTransactions theCreditTrans) {

    }

    public void addDebitTransaction(DebitTransactions theDebitTrans) {

    }

    public void removeDebitTransaction(DebitTransactions theDebitTrans) {

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<CreditTransactions> getCredit_transactions() {
        return credit_transactions;
    }

    public void setCredit_transactions(List<CreditTransactions> credit_transactions) {
        this.credit_transactions = credit_transactions;
    }

    public List<DebitTransactions> getDebit_transactions() {
        return debit_transactions;
    }

    public void setDebit_transactions(List<DebitTransactions> debit_transactions) {
        this.debit_transactions = debit_transactions;
    }

}
