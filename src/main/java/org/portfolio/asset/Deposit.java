package org.portfolio.asset;

import org.portfolio.asset.Impl.Asset;
import org.portfolio.asset.Impl.AssetType;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Deposit(String name,
                      double purchaseValue,
                      MonetaryUnit currency,
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
