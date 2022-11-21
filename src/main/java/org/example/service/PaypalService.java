package org.example.service;

import org.example.entities.OnLinePaymentService;

public class PaypalService implements OnLinePaymentService {
    @Override
    public Double paymentFee(Double amount) {

        return amount + amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer mounths) {

        return amount + (amount) * (mounths * 0.01);
    }
}
