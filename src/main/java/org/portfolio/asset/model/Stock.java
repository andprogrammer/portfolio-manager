package org.portfolio.asset.model;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.AssetType;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.unit.MonetaryUnit;

import java.time.LocalDate;

public record Stock(String name,
                    MonetaryUnit currency,
                    LocalDate purchaseDate,
                    int quantity,
                    double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.STOCK;
    }

    @Override
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
