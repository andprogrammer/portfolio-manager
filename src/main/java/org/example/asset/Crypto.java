package org.example.asset;

import org.example.asset.Impl.Asset;
import org.example.asset.Impl.AssetType;
import org.example.asset.monetaryUnit.MonetaryUnit;

import java.time.LocalDate;

public record Crypto(MonetaryUnit cryptoCurrency,
                     MonetaryUnit currency,
                     LocalDate purchaseDate,
                     double quantity,
                     double pricePerUnit
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CRYPTO;
    }

    @Override
    public String name() {
        return cryptoCurrency.getName();
    }

    @Override
    public double purchaseValue() {
        return quantity * pricePerUnit;
    }
}
