package org.example.entities;

public interface OnLinePaymentService {
    Double paymentFee(Double amount);
    Double interest(Double amount, Integer mounths);
}
