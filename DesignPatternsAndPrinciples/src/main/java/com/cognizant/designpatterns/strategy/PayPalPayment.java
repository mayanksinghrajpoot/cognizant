package com.cognizant.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayPalPayment implements PaymentStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PayPalPayment.class);
    private final String emailId;

    public PayPalPayment(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void pay(double amount) {
        logger.info("Paid ${} using PayPal (Account Email: {})", amount, emailId);
    }
}
