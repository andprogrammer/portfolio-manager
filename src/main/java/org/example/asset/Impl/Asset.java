package org.example.asset.Impl;

import java.time.LocalDate;

public interface Asset {
    AssetType type();
    String name();
    LocalDate purchaseDate();
}
