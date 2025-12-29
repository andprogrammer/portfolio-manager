package org.portfolio.asset;

import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.impl.AssetType;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Fund(String name,
                   LocalDate purchaseDate,
                   MonetaryUnit currency,
                   double units,
                   double purchaseUnitPrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.FUND;
    }

    public Money purchaseValue() {
        return new Money(units * purchaseUnitPrice, currency);
    }
}
