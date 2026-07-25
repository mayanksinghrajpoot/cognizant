package com.cognizant.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileApp implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(MobileApp.class);
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        logger.info("[Mobile App - {}] Stock: {} updated to ${}", appName, stockName, price);
    }
}
