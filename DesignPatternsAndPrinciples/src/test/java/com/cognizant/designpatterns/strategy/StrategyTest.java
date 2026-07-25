package com.cognizant.designpatterns.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    public void testCreditCardStrategy() {
        PaymentContext context = new PaymentContext();
        PaymentStrategy cc = new CreditCardPayment("1234-5678-9876", "John Doe");
        context.setPaymentStrategy(cc);

        assertDoesNotThrow(() -> context.executePayment(500.00));
    }

    @Test
    public void testPayPalStrategy() {
        PaymentContext context = new PaymentContext();
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");
        context.setPaymentStrategy(paypal);

        assertDoesNotThrow(() -> context.executePayment(250.75));
    }

    @Test
    public void testUnsetStrategyThrowsException() {
        PaymentContext context = new PaymentContext();
        assertThrows(IllegalStateException.class, () -> context.executePayment(10.00));
    }
}
