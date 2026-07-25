package com.cognizant.designpatterns.adapter;

public class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}
