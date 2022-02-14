package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Pojo.BankAlert;
import com.lucky.OkoedionBank.Services.IAlertService;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class AlertService implements IAlertService {


    private String ACCOUNT_SID;
    private String AUTH_TOKEN;

    public AlertService() {
//        ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//        AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

//        TODO - hide keys and use System.getenv

        ACCOUNT_SID = "";
        AUTH_TOKEN = "";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }


    @Override
    public void sendSmsAlert(BankAlert theAlert) {
        Message.creator(new PhoneNumber(theAlert.getRecipientPhoneNumber()), new PhoneNumber("Okoedion-Bank"), theAlert.getMessage()).create();

    }

    @Override
    public void sendEmailAlert(BankAlert theAlert) {
//        TODO
    }
}
