package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;

import java.time.LocalDate;

public record Fund(String fundName,
                   LocalDate purchaseDate,
                   double units,
                   double purchaseUnitPrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.FUND;
    }

    @Override
    public String name() {
        return fundName;
    }

    public double purchaseValue() {
        return units * purchaseUnitPrice;
    }
}
