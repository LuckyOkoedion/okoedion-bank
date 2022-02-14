package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.Account;
import com.lucky.OkoedionBank.Repositories.AccountRepository;
import com.lucky.OkoedionBank.Services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountService() {
        super();
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account theObj) {
        return accountRepository.save(theObj);
    }

    @Override
    public Account getOneById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public void update(Account theObj) {
        accountRepository.save(theObj);
    }

    @Override
    public void destroy(Long id) {
        Account theObj = getOneById(id);
        accountRepository.delete(theObj);
    }
}
