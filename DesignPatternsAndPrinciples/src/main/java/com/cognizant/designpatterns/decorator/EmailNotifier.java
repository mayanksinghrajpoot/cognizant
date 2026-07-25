package com.cognizant.designpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotifier implements Notifier {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotifier.class);

    @Override
    public void send(String message) {
        logger.info("Sending Email Notification: {}", message);
    }
}
