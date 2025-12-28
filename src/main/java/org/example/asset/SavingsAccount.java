package org.example.asset;

import java.time.LocalDate;

public record SavingsAccount(String bankName,
                             LocalDate openingDate,
                             double initialAmount,
                             double annualInterestRate
) implements ValuableAsset {

    @Override
    public String name() {
        return "Savings Account (" + bankName + ")";
    }

    @Override
    public LocalDate purchaseDate() {
        return openingDate;
    }

    @Override
    public double purchaseValue() {
        return 0;
    }

    @Override
    public double currentValue() {
        return 0;
    }
}
