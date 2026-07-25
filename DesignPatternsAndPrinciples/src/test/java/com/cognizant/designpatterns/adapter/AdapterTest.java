package com.cognizant.designpatterns.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {

    @Test
    public void testPaypalAdapter() {
        PaypalGateway paypalGateway = new PaypalGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalGateway);

        // Verify it runs without error
        assertDoesNotThrow(() -> paypalProcessor.processPayment(150.00));
    }

    @Test
    public void testStripeAdapter() {
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Verify it runs without error
        assertDoesNotThrow(() -> stripeProcessor.processPayment(250.50));
    }
}
