package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;

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
