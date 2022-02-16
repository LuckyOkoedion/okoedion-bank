package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.*;
import com.lucky.OkoedionBank.Pojo.*;
import com.lucky.OkoedionBank.Repositories.UserRepository;
import com.lucky.OkoedionBank.Services.IAccountService;
import com.lucky.OkoedionBank.Services.IAlertService;
import com.lucky.OkoedionBank.Services.ILoggingService;
import com.lucky.OkoedionBank.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    private IAccountService accountService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private IAlertService alertService;
    private ILoggingService loggingService;

    public UserService(AccountService theAccountService,
                       AlertService alertService, LoggingService loggingService) {
        super();
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
    public UserDto create(SignupDto theObj) {
//        Create a user and generate bank account for him/her
        String encodedPassword = bCryptPasswordEncoder.encode(theObj.getPassword());
        UserEntity theInput = new UserEntity();
        theInput.setAddress(theObj.getAddress());
        theInput.setEmail(theObj.getEmail());
        theInput.setFirst_name(theObj.getFirst_name());
        theInput.setLast_name(theObj.getLast_name());
        theInput.setPhone_number(theObj.getPhone_number());
        theInput.setPassword(encodedPassword);
        UserEntity theUser = userRepository.save(theInput);
        Account account = new Account();
        account.setAccount_name(theUser.getFirst_name() + " " + theUser.getLast_name());
        account.setAccount_type("PRIVATE");
        account.setAccount_number(generateAccountNumber());
        Account theAccount = accountService.create(account);
        UserEntity finalUser = userRepository.save(theUser);
        UserDto userResponse = new UserDto();
        userResponse.setAccounts(finalUser.getAccounts());
        userResponse.setAddress(finalUser.getAddress());
        userResponse.setEmail(finalUser.getEmail());
        userResponse.setLast_name(finalUser.getLast_name());
        userResponse.setFirst_name(finalUser.getFirst_name());
        userResponse.setPhone_number(finalUser.getPhone_number());
        userResponse.setId(finalUser.getId());

//        Send alert and log the event

        UserEntity affectedUser = finalUser;
        String affectedUserMessage = "Welcome to Okoedion Bank. Your new Account number is" + theAccount.getAccount_number() + "Visit any branch to pick your ATM.";
        BankAlert affectedUserAlert = new BankAlert(affectedUserMessage, affectedUser.getPhone_number(), affectedUser.getEmail(), affectedUser.getId());

//        alertService.sendSmsAlert(affectedUserAlert);
        alertService.sendAppAlert(affectedUserAlert);

        LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
        LoggableEventMessage logMessage = new LoggableEventMessage("Debit Transaction Occurred", logSource);

        loggingService.localLogInfo(logMessage);
        loggingService.logToApp(logMessage);


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
        userResponse.setId(theUser.getId());
        return userResponse;
    }

    @Override
    public void update(UserEntity theObj) {
        userRepository.save(theObj);

//         Send alert and log the event
        String message = theObj.getFirst_name() + " " + theObj.getLast_name() + " " + "profile data has been updated. If you did not receive / perform any operation recently, to warrant this, kindly contact customer service.";
        BankAlert theAlert = new BankAlert(message, theObj.getPhone_number(), theObj.getEmail(), theObj.getId());
        //alertService.sendSmsAlert(theAlert);
        alertService.sendAppAlert(theAlert);

        LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
        LoggableEventMessage logMessage = new LoggableEventMessage( message, logSource);

        loggingService.localLogInfo(logMessage);
        loggingService.logToApp(logMessage);
    }

    @Override
    public void destroy(Long id) {
        UserEntity theUser = userRepository.getById(id);
        userRepository.delete(theUser);

//        Send alert and log the event

        String message = theUser.getFirst_name() + " " + theUser.getLast_name() + " " + "with phone number" + " " + theUser.getPhone_number() + "and email address" + " " + "has been deleted from the database.";
        BankAlert theAlert = new BankAlert(message, theUser.getPhone_number(), theUser.getEmail(), theUser.getId());
        //alertService.sendSmsAlert(theAlert);
        alertService.sendAppAlert(theAlert);

        LoggableEventSource logSource = new LoggableEventSource(this.getClass().getName());
        LoggableEventMessage logMessage = new LoggableEventMessage( message, logSource);

        loggingService.localLogInfo(logMessage);
        loggingService.logToApp(logMessage);
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
