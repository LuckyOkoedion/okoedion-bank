package com.lucky.OkoedionBank.Services.impl;

import com.lucky.OkoedionBank.Entities.ActivityLogs;
import com.lucky.OkoedionBank.Entities.LoggableEventMessage;
import com.lucky.OkoedionBank.Repositories.LogsRepository;
import com.lucky.OkoedionBank.Services.ILoggingService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoggingService implements ILoggingService {

    private LogsRepository logsRepository;
    Logger logger;

    public LoggingService(LogsRepository theRepo) {
        super();
        logsRepository = theRepo;
        logger = LogManager.getLogger();
    }

    @Override
    public void logToApp(LoggableEventMessage message) {
//        ActivityLogs theObj = new ActivityLogs();
//        theObj.setEvent_source(message.getSource().getClassName());
//        theObj.setEvent_description(message.getMessageText());
//        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        theObj.setTimestamp(timestamp);
//        logsRepository.save(theObj);
    }

    @Override
    public void logToFile(LoggableEventMessage message) {
//        TODO - later
    }

    @Override
    public void localLogDebug(LoggableEventMessage message) {
        logger.debug(message.getMessageText());
    }

    @Override
    public void localLogError(LoggableEventMessage message) {
        logger.error(message.getMessageText());
    }

    @Override
    public void localLogWarn(LoggableEventMessage message) {
        logger.warn(message.getMessageText());
    }

    @Override
    public void localLogTrace(LoggableEventMessage message) {
        logger.trace(message.getMessageText());
    }

    @Override
    public void localLogInfo(LoggableEventMessage message) {
        logger.info(message.getMessageText());
    }
}
