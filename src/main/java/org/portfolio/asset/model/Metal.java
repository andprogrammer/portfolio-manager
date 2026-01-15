package org.portfolio.asset.model;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.AssetType;
import org.portfolio.asset.unit.MonetaryUnit;

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
