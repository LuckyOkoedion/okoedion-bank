package com.lucky.OkoedionBank.Controllers.impl;

import com.lucky.OkoedionBank.Controllers.IDebitTransactionsController;
import com.lucky.OkoedionBank.Entities.DebitTransactions;
import com.lucky.OkoedionBank.Services.IDebitTransactionsService;
import com.lucky.OkoedionBank.Services.impl.DebitTransactionsService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/debit")
public class DebitTransactionsController implements IDebitTransactionsController {

//   Note that the type of `debitTransactionsService` below is an interface, not a class. This is for
//   loose coupling / Strategy design pattern.
    private IDebitTransactionsService debitTransactionsService;

//        Here you can now swap implementation at ease without need for refactoring.
//        Just use constructor dependency injection to provide any class, so long as the class
//        implements the `IDebitTransactionsService` interface.
    public DebitTransactionsController(DebitTransactionsService theDebitTransactionService) {
        super();
        debitTransactionsService = theDebitTransactionService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<DebitTransactions>> getAll() {
        try {
            return new ResponseEntity<>(debitTransactionsService.getAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<DebitTransactions> create(@RequestBody DebitTransactions theObj) {
        try {
            return new ResponseEntity<>(debitTransactionsService.create(theObj), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DebitTransactions> getOneById(@PathVariable(value="id") Long id) {
        try {
            return new ResponseEntity<>(debitTransactionsService.getOneById(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public void update(@RequestBody DebitTransactions theObj) {
        debitTransactionsService.update(theObj);
    }

    @DeleteMapping("/{id}")
    @Override
    public void destroy(@PathVariable(value="id") Long id) {
        debitTransactionsService.destroy(id);
    }
}
