package org.portfolio.asset.Impl;

import java.time.LocalDate;

public interface Asset {

    AssetType type();
    String name();
    LocalDate purchaseDate();
    double purchaseValue();
    default double profit() {
        return purchaseValue();
    }
}
