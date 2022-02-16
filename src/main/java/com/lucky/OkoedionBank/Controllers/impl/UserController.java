package com.lucky.OkoedionBank.Controllers.impl;

import com.lucky.OkoedionBank.Controllers.IUserController;
import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Pojo.UserDto;
import com.lucky.OkoedionBank.Services.IUserService;
import com.lucky.OkoedionBank.Services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value =  "/user")
public class UserController implements IUserController {

    //   Note that the type of `userService` below is an interface, not a class. This is for
//   loose coupling / Strategy design pattern.

    private IUserService userService;

    //        Here you can now swap implementation at ease without need for refactoring.
//        Just use constructor dependency injection to provide any class, so long as the class
//        implements the `IUserService` interface.

    public UserController(UserService theUserService) {
        super();
        userService = theUserService;
    }


    @GetMapping
    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserDto> getOneById(@PathVariable(value="id") Long id) {
        try {
            return new ResponseEntity<>(userService.getOneById(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @Override
    public void update(@RequestBody UserEntity theObj) {
        userService.update(theObj);
    }

    @DeleteMapping("/{id}")
    @Override
    public void destroy(@PathVariable(value="id") Long id) {
        userService.destroy(id);
    }


}
