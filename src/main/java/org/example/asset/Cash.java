package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;
import org.example.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Cash(MonetaryUnit currency,
                   LocalDate purchaseDate,
                   double amount
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CASH;
    }

    @Override
    public String name() {
        return currency.getName();
    }
}
