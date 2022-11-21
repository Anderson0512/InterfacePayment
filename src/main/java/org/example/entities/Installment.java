package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Installment {
    private LocalDate dueDate;
    private Double amount;

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Installment() {
    }

    @Override
    public String toString() {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Due Date: " + sdf.format(dueDate) +
                " - $" + String.format("%.2f", amount);
    }
}
