package com.lucky.OkoedionBank.Services;

import com.lucky.OkoedionBank.Pojo.LoggableEventMessage;
import com.lucky.OkoedionBank.Pojo.LoggableEventSource;

public interface IGeneralLoggingServiceBlueprint<E> {

    void logToDb (E message);
    void logToFile (E message);
    void localLogDebug (E message);
    void localLogError (E message);
    void localLogWarn (E message);
    void localLogTrace (E message);
    void localLogInfo (E message);

}
