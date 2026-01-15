package org.portfolio.asset.core;

import org.portfolio.asset.model.Money;

import java.time.LocalDate;

public interface Asset {
    AssetType type();
    String name();
    LocalDate purchaseDate();
    Money purchaseValue();
    default Money profit() {
        return purchaseValue();
    }
}
