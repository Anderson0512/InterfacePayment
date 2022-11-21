package org.example.service;

import org.example.entities.Contract;
import org.example.entities.Installment;
import org.example.entities.OnLinePaymentService;

import java.time.LocalDate;

public class InstallmentContractService {
    private final OnLinePaymentService onLinePaymentService;

    public InstallmentContractService(OnLinePaymentService onLinePaymentService) {
        this.onLinePaymentService = onLinePaymentService;
    }
    public void processContract(Contract contract, Integer mounths){

        for (int i = 0; i < mounths; i++) {

            LocalDate dueDate = contract.getDate().plusMonths(i + 1);
            Double interest = onLinePaymentService.interest(contract.getTotalValue()/ mounths, (i + 1));
            Double paymentFee = onLinePaymentService.paymentFee(interest);

            contract.getInstallments().add(new Installment(dueDate, paymentFee));
        }

    }
}
