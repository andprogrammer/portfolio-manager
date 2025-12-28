package org.example.asset;

import java.time.LocalDate;

public record Bond(String name,
                   LocalDate purchaseDate,
                   double nominalAmount,
                   double annualInterestRate,
                   int durationMonths
) implements ValuableAsset {

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }

    @Override
    public double purchaseValue() {
        return nominalAmount;
    }

    @Override
    public double currentValue() {
        double years = durationMonths / 12.0;
        return nominalAmount * (1 + (annualInterestRate / 100) * years);
    }
}
