package org.example.asset;

import org.example.asset.Impl.AssetType;
import org.example.asset.Impl.ValuableAsset;
import org.example.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record SavingsAccount(String name,
                             String bankName,
                             double purchaseValue,
                             MonetaryUnit currency,
                             LocalDate purchaseDate,
                             double annualInterestRate
) implements ValuableAsset {

    @Override
    public AssetType type() {
        return AssetType.SAVINGS_ACCOUNT;
    }

    @Override
    public double currentValue() {
        long days = ChronoUnit.DAYS.between(purchaseDate, LocalDate.now());
        double years = days / 365.0;
        return purchaseValue * (1 + (annualInterestRate / 100) * years);
    }
}
