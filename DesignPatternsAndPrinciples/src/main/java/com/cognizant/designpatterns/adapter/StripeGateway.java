package com.cognizant.designpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StripeGateway {
    private static final Logger logger = LoggerFactory.getLogger(StripeGateway.class);

    public void charge(double amount) {
        logger.info("Processing payment of ${} through Stripe Gateway.", amount);
    }
}
