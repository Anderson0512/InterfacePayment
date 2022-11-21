package org.example.service;

import org.example.entities.Contract;
import org.example.entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ContractService {
    public static void contractService() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), sdf);
        System.out.print("Contract value: ");
        Double value = sc.nextDouble();
        System.out.print("Enter with installments number: ");
        int n = sc.nextInt();

        Contract contract = new Contract(number, date, value);

        InstallmentContractService service = new InstallmentContractService(new PaypalService());
        service.processContract(contract, n);
        System.out.println();
        System.out.println("Installments:");

        for (Installment list : contract.getInstallments()) {
            System.out.println(list);
        }

    }
}
