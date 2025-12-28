package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;

import java.time.LocalDate;

public record Deposit(String name,
                      LocalDate purchaseDate,
                      double interestRate,
                      int durationMonths
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.DEPOSIT;
    }

    public LocalDate maturityDate() {
        return purchaseDate.plusMonths(durationMonths);
    }

    public boolean isMatured() {
        return LocalDate.now().isAfter(maturityDate());
    }
}
