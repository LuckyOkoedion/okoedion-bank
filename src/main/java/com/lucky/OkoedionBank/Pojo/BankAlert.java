package com.lucky.OkoedionBank.Pojo;

import com.lucky.OkoedionBank.Entities.UserEntity;

public class BankAlert {
    private String message;
    private String recipientPhoneNumber;
    private String getRecipientEmail;


    public BankAlert(String message, String recipientPhoneNumber,
                     String getRecipientEmail) {
        this.message = message;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.getRecipientEmail = getRecipientEmail;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getGetRecipientEmail() {
        return getRecipientEmail;
    }

    public void setGetRecipientEmail(String getRecipientEmail) {
        this.getRecipientEmail = getRecipientEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
