package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.DebitTransactions;
import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Pojo.BankAlert;
import com.lucky.OkoedionBank.Pojo.LoggableEventMessage;
import com.lucky.OkoedionBank.Pojo.LoggableEventSource;
import com.lucky.OkoedionBank.Repositories.DebitTransactionsRepository;
import com.lucky.OkoedionBank.Services.IAlertService;
import com.lucky.OkoedionBank.Services.IDebitTransactionsService;
import com.lucky.OkoedionBank.Services.ILoggingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitTransactionsService implements IDebitTransactionsService {

    private DebitTransactionsRepository debitTransactionsRepository;
//    private IAlertService alertService;
    private ILoggingService loggingService;

    public DebitTransactionsService(DebitTransactionsRepository theRepo, AlertService alertService, LoggingService loggingService) {
        super();
        debitTransactionsRepository = theRepo;
//        alertService = alertService;
        loggingService = loggingService;
    }

    @Override
    public List<DebitTransactions> getAll() {
        return debitTransactionsRepository.findAll();
    }

    @Override
    public DebitTransactions create(DebitTransactions theObj) {
        DebitTransactions theResult = debitTransactionsRepository.save(theObj);
//        Send alert and log transaction

//        if(theResult != null) {
//            UserEntity affectedUser = theObj.getDebited_account().getUser();
//            String affectedUserMessage = theObj.getAmount() + "has been debited from your account." + " " + "Please if you did not initiate it, kindly contact customer care.";
//            BankAlert affectedUserAlert = new BankAlert(affectedUserMessage, affectedUser.getPhone_number(), affectedUser.getEmail());
//
////            alertService.sendSmsAlert(affectedUserAlert);
//
//            LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
//            LoggableEventMessage logMessage = new LoggableEventMessage("Debit Transaction Occurred", logSource);
//
//            loggingService.localLogInfo(logMessage);
//            loggingService.logToDb(logMessage);
//        }

        return  theResult;
    }

    @Override
    public DebitTransactions getOneById(Long id) {
        return debitTransactionsRepository.getById(id);
    }

    @Override
    public void update(DebitTransactions theObj) {
        debitTransactionsRepository.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        DebitTransactions theObj = getOneById(id);
        debitTransactionsRepository.delete(theObj);
    }
}
