package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;
import org.example.asset.monetaryUnit.MonetaryUnit;

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
    public double purchaseValue() {
        return quantity * pricePerUnit;
    }
}
