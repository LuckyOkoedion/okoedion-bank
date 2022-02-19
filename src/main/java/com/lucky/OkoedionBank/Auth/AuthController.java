package com.lucky.OkoedionBank.Auth;

import com.lucky.OkoedionBank.Controllers.IAuthController;
import com.lucky.OkoedionBank.Pojo.LoginDto;
import com.lucky.OkoedionBank.Pojo.LoginResponse;
import com.lucky.OkoedionBank.Pojo.SignupDto;
import com.lucky.OkoedionBank.Pojo.UserDto;
import com.lucky.OkoedionBank.Services.IUserService;
import com.lucky.OkoedionBank.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping(value =  "/auth")
public class AuthController implements IAuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTUtil jwtUtil;

    private IUserService userService;

    public AuthController(UserService userService) {
        this.userService =userService;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<UserDto> register(SignupDto theObj) {
        try {
            return new ResponseEntity<>(userService.create(theObj), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    @Override
    public ResponseEntity<LoginResponse> login(LoginDto theObj) {
        try {

            try {
                UsernamePasswordAuthenticationToken authInputToken =
                        new UsernamePasswordAuthenticationToken(theObj.getEmail(), theObj.getPassword());

                authManager.authenticate(authInputToken);

                String token = jwtUtil.generateToken(theObj.getEmail());

                LoginResponse result = new LoginResponse(token);
                return  new ResponseEntity(result, HttpStatus.OK);
            }catch (AuthenticationException authExc){
                throw new RuntimeException("Invalid Login Credentials");
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
