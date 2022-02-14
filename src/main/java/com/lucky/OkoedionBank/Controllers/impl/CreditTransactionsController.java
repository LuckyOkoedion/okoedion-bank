package com.lucky.OkoedionBank.Controllers.impl;

import com.lucky.OkoedionBank.Controllers.ICreditTransactionsController;
import com.lucky.OkoedionBank.Entities.CreditTransactions;
import com.lucky.OkoedionBank.Services.ICreditTransactionsService;
import com.lucky.OkoedionBank.Services.impl.CreditTransactionsService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/credit")
public class CreditTransactionsController implements ICreditTransactionsController {

    //   Note that the type of `creditTransactionsService` below is an interface, not a class. This is for
//   loose coupling / Strategy design pattern.

    private ICreditTransactionsService creditTransactionsService;

    //        Here you can now swap implementation at ease without need for refactoring.
//        Just use constructor dependency injection to provide any class, so long as the class
//        implements the `ICreditTransactionsService` interface.

    public CreditTransactionsController (CreditTransactionsService theCreditTransactionsService) {
        super();
        creditTransactionsService = theCreditTransactionsService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CreditTransactions>> getAll() {
        try {
            return new ResponseEntity<>(creditTransactionsService.getAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<CreditTransactions> create( @RequestBody CreditTransactions theObj) {
        try {
            return new ResponseEntity<>(creditTransactionsService.create(theObj), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CreditTransactions> getOneById(@PathVariable(value="id") Long id) {
        try {
            return new ResponseEntity<>(creditTransactionsService.getOneById(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public void update(@RequestBody CreditTransactions theObj) {
        creditTransactionsService.update(theObj);
    }

    @DeleteMapping("/{id}")
    @Override
    public void destroy(@PathVariable(value="id") Long id) {
        creditTransactionsService.destroy(id);
    }
}
