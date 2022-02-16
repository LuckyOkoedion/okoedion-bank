package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.CreditTransactions;
import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Pojo.BankAlert;
import com.lucky.OkoedionBank.Pojo.LoggableEventMessage;
import com.lucky.OkoedionBank.Pojo.LoggableEventSource;
import com.lucky.OkoedionBank.Repositories.CreditTransactionRepository;
import com.lucky.OkoedionBank.Services.IAlertService;
import com.lucky.OkoedionBank.Services.ICreditTransactionsService;
import com.lucky.OkoedionBank.Services.ILoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditTransactionsService implements ICreditTransactionsService {

    @Autowired
    private CreditTransactionRepository creditTransactionRepository;

//    private IAlertService alertService;
    private ILoggingService loggingService;

    public CreditTransactionsService(
                                     LoggingService theLoggingService

//                                     AlertService theAlertService
    ) {
        super();
//        alertService = theAlertService;
        loggingService = theLoggingService;
    }

    @Override
    public List<CreditTransactions> getAll() {
        return creditTransactionRepository.findAll();
    }

    @Override
    public CreditTransactions create(CreditTransactions theObj) {
        CreditTransactions theResult = creditTransactionRepository.save(theObj);

        if(theResult != null) {
            //        send alert and log transaction
//            UserEntity sender = theObj.getSender();
//            UserEntity reciever = theObj.getRecipient();
//            String senderMessage = theObj.getAmount() + "has been transfered from your account to" + " " + theObj.getRecipient_account() + " " + "Please if you did not initiate it, kindly contact customer care.";
//            String recipientMessage = "Your account:" + " " + "has been credited with" + " " + theObj.getAmount() + " " + "from" + " " + theObj.getSender_account();
//
//            BankAlert senderAlert = new BankAlert(senderMessage, sender.getPhone_number(), sender.getEmail());
//            BankAlert recipientAlert = new BankAlert(recipientMessage, reciever.getPhone_number(), reciever.getEmail() );

//            alertService.sendSmsAlert(senderAlert);
//            alertService.sendSmsAlert(recipientAlert);

            LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
            LoggableEventMessage logMessage = new LoggableEventMessage("Credit Transaction Occurred", logSource);

            loggingService.localLogInfo(logMessage);
            loggingService.logToDb(logMessage);
        }

        return  theResult;


    }

    @Override
    public CreditTransactions getOneById(Long id) {
        return creditTransactionRepository.getById(id);
    }

    @Override
    public void update(CreditTransactions theObj) {
        creditTransactionRepository.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        CreditTransactions theObj = getOneById(id);
        creditTransactionRepository.delete(theObj);

    }
}
