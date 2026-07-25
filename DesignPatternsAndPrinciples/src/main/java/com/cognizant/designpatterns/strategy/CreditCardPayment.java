package com.cognizant.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCardPayment implements PaymentStrategy {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardPayment.class);
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        logger.info("Paid ${} using Credit Card (Holder: {}, Card Number: {})", amount, cardHolderName, cardNumber);
    }
}
