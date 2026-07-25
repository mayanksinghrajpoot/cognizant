package com.cognizant.designpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaypalGateway {
    private static final Logger logger = LoggerFactory.getLogger(PaypalGateway.class);

    public void makePayment(double amount) {
        logger.info("Processing payment of ${} through PayPal Gateway.", amount);
    }
}
