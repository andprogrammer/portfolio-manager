package org.portfolio.asset.model;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.AssetType;
import org.portfolio.asset.unit.MonetaryUnit;

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
    public Money purchaseValue() {
        return new Money(quantity * pricePerUnit, currency);
    }
}
