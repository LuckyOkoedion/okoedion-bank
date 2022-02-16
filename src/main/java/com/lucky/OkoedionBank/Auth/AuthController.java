package com.lucky.OkoedionBank.Auth;

import com.lucky.OkoedionBank.Controllers.IAuthController;
import com.lucky.OkoedionBank.Pojo.SignupDto;
import com.lucky.OkoedionBank.Pojo.UserDto;
import com.lucky.OkoedionBank.Services.IUserService;
import com.lucky.OkoedionBank.Services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/register")
public class AuthController implements IAuthController {

    private IUserService userService;

    public AuthController(UserService userService) {
        this.userService =userService;
    }

    @Override
    public ResponseEntity<UserDto> register(SignupDto theObj) {
        try {
            return new ResponseEntity<>(userService.create(theObj), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
