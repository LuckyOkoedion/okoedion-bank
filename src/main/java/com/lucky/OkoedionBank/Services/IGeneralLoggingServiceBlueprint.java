package com.lucky.OkoedionBank.Services;

public interface IGeneralLoggingServiceBlueprint<E> {

    void logToApp(E message);
    void logToFile (E message);
    void localLogDebug (E message);
    void localLogError (E message);
    void localLogWarn (E message);
    void localLogTrace (E message);
    void localLogInfo (E message);

}
