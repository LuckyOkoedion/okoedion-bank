package com.lucky.OkoedionBank.Controllers;

import com.lucky.OkoedionBank.Pojo.SignupDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthController {
    @PostMapping
    <T> T register(@RequestBody SignupDto theObj);
}