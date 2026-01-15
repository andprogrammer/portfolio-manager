package org.portfolio.asset.model;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.AssetType;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.unit.MonetaryUnit;

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
