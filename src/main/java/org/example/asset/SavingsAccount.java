package org.example.asset;

import org.example.asset.Impl.AssetType;
import org.example.asset.Impl.ValuableAsset;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record SavingsAccount(String name,
                             String bankName,
                             LocalDate openingDate,
                             double initialAmount,
                             double annualInterestRate
) implements ValuableAsset {

    @Override
    public AssetType type() {
        return AssetType.SAVINGS_ACCOUNT;
    }

    @Override
    public LocalDate purchaseDate() {
        return openingDate;
    }

    @Override
    public double purchaseValue() {
        return initialAmount;
    }

    @Override
    public double currentValue() {
        long days = ChronoUnit.DAYS.between(openingDate, LocalDate.now());
        double years = days / 365.0;
        return initialAmount * (1 + (annualInterestRate / 100) * years);
    }
}
