package org.portfolio.asset.model;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.AssetType;
import org.portfolio.asset.core.Money;

import java.time.LocalDate;

public record Cash(Money purchaseValue,
                   LocalDate purchaseDate
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.CASH;
    }

    @Override
    public String name() {
        return purchaseValue.currency().toString();
    }
}
