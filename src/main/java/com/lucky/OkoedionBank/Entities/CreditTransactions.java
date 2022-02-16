package com.lucky.OkoedionBank.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class CreditTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long recipient;
    @Column
    private Long sender;
    @OneToOne
    @MapsId
    private Account sender_account;
    @OneToOne
    @MapsId
    private Account recipient_account;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String timestamp;
    @Column(nullable = false)
    private String credit_channel;

    public CreditTransactions() {

    }

    public CreditTransactions(Long recipient, Long sender, Account sender_account,
                              Account recipient_account, BigDecimal amount,
                              String timestamp, String credit_channel) {
        super();
        this.amount = amount;
        this.credit_channel = credit_channel;
        this.recipient = recipient;
        this.recipient_account = recipient_account;
        this.sender = sender;
        this.sender_account = sender_account;
        this.timestamp = timestamp;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipient() {
        return recipient;
    }

    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Account getSender_account() {
        return sender_account;
    }

    public void setSender_account(Account sender_account) {
        this.sender_account = sender_account;
    }

    public Account getRecipient_account() {
        return recipient_account;
    }

    public void setRecipient_account(Account recipient_account) {
        this.recipient_account = recipient_account;
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

    public String getCredit_channel() {
        return credit_channel;
    }

    public void setCredit_channel(String credit_channel) {
        this.credit_channel = credit_channel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditTransactions)) return false;
        CreditTransactions that = (CreditTransactions) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
