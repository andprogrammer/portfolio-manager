package org.portfolio.asset;

import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.impl.AssetType;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Metal(MonetaryUnit metal,
                    LocalDate purchaseDate,
                    MonetaryUnit currency,
                    double quantity,
                    double weight,
                    double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.METAL;
    }

    @Override
    public String name() {
        return metal.getName();
    }

    @Override
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
