package org.portfolio.asset.impl;

import org.portfolio.asset.Money;

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
