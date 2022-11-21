package org.example.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalValue;
    @Setter(AccessLevel.NONE)
    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Due Date: " + sdf.format(date) +
                " - $" + String.format("%.2f", totalValue);
    }
}
