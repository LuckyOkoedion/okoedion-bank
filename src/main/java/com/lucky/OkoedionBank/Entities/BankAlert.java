package com.lucky.OkoedionBank.Entities;

import javax.persistence.*;

@Entity
@Table
public class BankAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;
    @Column
    private String recipientPhoneNumber;
    @Column
    private String recipientEmail;
    @Column
    private Long recipientId;
    @Column
    private Boolean read;


    public BankAlert(String message, String recipientPhoneNumber,
                     String recipientEmail, Long recipientId) {
        this.message = message;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.recipientEmail = recipientEmail;
        this.recipientId = recipientId;
        this.read = false;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
