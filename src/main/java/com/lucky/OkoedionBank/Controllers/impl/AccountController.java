package com.lucky.OkoedionBank.Controllers.impl;

import com.lucky.OkoedionBank.Controllers.IAccountController;
import com.lucky.OkoedionBank.Entities.Account;
import com.lucky.OkoedionBank.Services.IAccountService;
import com.lucky.OkoedionBank.Services.impl.AccountService;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/account")
public class AccountController implements IAccountController {

    //   Note that the type of `accountService` below is an interface, not a class. This is for
//   loose coupling / Strategy design pattern.

    private IAccountService accountService;

    //        Here you can now swap implementation at ease without need for refactoring.
//        Just use constructor dependency injection to provide any class, so long as the class
//        implements the `IAccountService` interface.

    public  AccountController(AccountService theAccountService) {
        super();
        accountService = theAccountService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Account>> getAll() {
        try {
            return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<Account> create( @RequestBody Account theObj) {
        try {
            return new ResponseEntity<>(accountService.create(theObj), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Account> getOneById(@PathVariable(value="id") Long id) {
        try {
            return new ResponseEntity<>(accountService.getOneById(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public void update(@RequestBody Account theObj) {
            accountService.update(theObj);
    }

    @DeleteMapping("/{id}")
    @Override
    public void destroy(@PathVariable(value="id") Long id) {
        accountService.destroy(id);
    }
}
