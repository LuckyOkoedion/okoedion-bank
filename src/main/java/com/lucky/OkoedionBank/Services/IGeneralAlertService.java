package com.lucky.OkoedionBank.Services;

public interface IGeneralAlertService<T> {
    void sendSmsAlert (T theAlert);
    void sendEmailAlert (T theAlert);
}
