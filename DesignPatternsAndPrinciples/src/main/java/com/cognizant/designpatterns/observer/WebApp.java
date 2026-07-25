package com.cognizant.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApp implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(WebApp.class);
    private final String clientName;

    public WebApp(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double price) {
        logger.info("[Web App - {}] Stock: {} updated to ${}", clientName, stockName, price);
    }
}
