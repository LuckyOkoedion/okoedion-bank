package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.Account;
import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Pojo.*;
import com.lucky.OkoedionBank.Repositories.UserRepository;
import com.lucky.OkoedionBank.Services.IAccountService;
import com.lucky.OkoedionBank.Services.IAlertService;
import com.lucky.OkoedionBank.Services.ILoggingService;
import com.lucky.OkoedionBank.Services.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private IAccountService accountService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private IAlertService alertService;
    private ILoggingService loggingService;

    public UserService(UserRepository theRepo, AccountService theAccountService,
                       AlertService alertService, LoggingService loggingService) {
        super();
        userRepository = theRepo;
        this.accountService = theAccountService;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        alertService = alertService;
        loggingService = loggingService;

    }


    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public UserDto create(UserEntity theObj) {
//        Create a user and generate bank account for him/her
        String encodedPassword = bCryptPasswordEncoder.encode(theObj.getPassword());
        theObj.setPassword(encodedPassword);
        UserEntity theUser = userRepository.save(theObj);
        Account account = new Account();
        account.setUser(theUser);
        account.setAccount_name(theUser.getFirst_name() + " " + theUser.getLast_name());
        account.setAccount_type("PRIVATE");
        account.setAccount_number(generateAccountNumber());
        Account theAccount = accountService.create(account);
        theUser.addAccount(theAccount);
        UserEntity finalUser = userRepository.save(theUser);
        UserDto userResponse = new UserDto();
        userResponse.setAccounts(finalUser.getAccounts());
        userResponse.setAddress(finalUser.getAddress());
        userResponse.setEmail(finalUser.getEmail());
        userResponse.setLast_name(finalUser.getLast_name());
        userResponse.setFirst_name(finalUser.getFirst_name());
        userResponse.setPhone_number(finalUser.getPhone_number());
        userResponse.setCredit_transactions(finalUser.getCredit_transactions());
        userResponse.setId(finalUser.getId());

//        Send alert and log the event

        UserEntity affectedUser = finalUser;
        String affectedUserMessage = "Welcome to Okoedion Bank. Your new Account number is" + theAccount.getAccount_number() + "Visit any branch to pick your ATM.";
        BankAlert affectedUserAlert = new BankAlert(affectedUserMessage, affectedUser.getPhone_number(), affectedUser.getEmail());

        alertService.sendSmsAlert(affectedUserAlert);

        LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
        LoggableEventMessage logMessage = new LoggableEventMessage("Debit Transaction Occurred", logSource);

        loggingService.localLogInfo(logMessage);
        loggingService.logToDb(logMessage);


        return userResponse;
    }

    @Override
    public UserDto getOneById(Long id) {
        UserEntity theUser = userRepository.getById(id);
        UserDto userResponse = new UserDto();
        userResponse.setAccounts(theUser.getAccounts());
        userResponse.setAddress(theUser.getAddress());
        userResponse.setEmail(theUser.getEmail());
        userResponse.setLast_name(theUser.getLast_name());
        userResponse.setFirst_name(theUser.getFirst_name());
        userResponse.setPhone_number(theUser.getPhone_number());
        userResponse.setCredit_transactions(theUser.getCredit_transactions());
        userResponse.setId(theUser.getId());
        return userResponse;
    }

    @Override
    public void update(UserEntity theObj) {
        userRepository.save(theObj);

//        TODO - Send alert and log the event
    }

    @Override
    public void destroy(Long id) {
        UserEntity theUser = userRepository.getById(id);
        userRepository.delete(theUser);

//        TODO - Send alert and log the event
    }

    private String generateAccountNumber(){
        Random rand = new Random();
        String accountNumber = "6";
        for (int i = 0; i < 9; i++)
        {
            int n = rand.nextInt(10) + 0;
            accountNumber += Integer.toString(n);
        }
       return accountNumber;

    }

}
