package org.portfolio.asset;

import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.impl.AssetType;

import java.time.LocalDate;

public record Fund(String name,
                   LocalDate purchaseDate,
                   double units,
                   double purchaseUnitPrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.FUND;
    }

    public double purchaseValue() {
        return units * purchaseUnitPrice;
    }
}
