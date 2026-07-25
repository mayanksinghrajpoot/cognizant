package com.cognizant.designpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSNotifierDecorator extends NotifierDecorator {
    private static final Logger logger = LoggerFactory.getLogger(SMSNotifierDecorator.class);

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        logger.info("Sending SMS Notification: {}", message);
    }
}
