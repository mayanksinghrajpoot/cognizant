package com.cognizant.designpatterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackNotifierDecorator extends NotifierDecorator {
    private static final Logger logger = LoggerFactory.getLogger(SlackNotifierDecorator.class);

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        logger.info("Sending Slack Notification: {}", message);
    }
}
