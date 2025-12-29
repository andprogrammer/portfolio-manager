package org.portfolio.asset;

import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.impl.AssetType;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Cash(double purchaseValue,
                   MonetaryUnit currency,
                   LocalDate purchaseDate
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
