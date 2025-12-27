package org.example.asset;

import java.time.LocalDate;

public record Bond(String name,
                   LocalDate purchaseDate,
                   double interestRate,
                   int durationMonths
) implements Asset {

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
