package com.lucky.OkoedionBank.Entities;


import com.lucky.OkoedionBank.Pojo.TransactionChannels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class DebitTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String debit_channel;
    @OneToOne
    @MapsId
    private Account debited_account;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String timestamp;


    public DebitTransactions() {

    }


    public DebitTransactions(String debit_channel, Account debited_account, BigDecimal amount, String timestamp) {
        super();
        this.debit_channel = debit_channel;
        this.debited_account = debited_account;
        this.amount = amount;
        this.timestamp = timestamp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDebit_channel() {
        return debit_channel;
    }

    public void setDebit_channel(String debit_channel) {
        this.debit_channel = debit_channel;
    }

    public Account getDebited_account() {
        return debited_account;
    }

    public void setDebited_account(Account debited_account) {
        this.debited_account = debited_account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DebitTransactions)) return false;
        DebitTransactions that = (DebitTransactions) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
