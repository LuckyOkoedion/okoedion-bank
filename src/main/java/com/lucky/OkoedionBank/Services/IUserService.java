package com.lucky.OkoedionBank.Services;

import com.lucky.OkoedionBank.Entities.UserEntity;
import com.lucky.OkoedionBank.Pojo.SignupDto;
import com.lucky.OkoedionBank.Pojo.UserDto;

public interface IUserService extends ICrudServiceWithSeparateResponse<UserEntity, UserDto, SignupDto> {

}
